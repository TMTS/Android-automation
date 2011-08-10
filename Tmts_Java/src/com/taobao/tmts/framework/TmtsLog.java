/* TMTS - Android automation testing Framework.
 Copyright (C) 2010-2011 TaoBao UI AutoMan Team

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., HuaXing road, Hangzhou,China. 
 Email:taichan@taobao.com,shidun@taobao.com,bingyang@taobao.com
*/
package com.taobao.tmts.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

/**
 * Class for printing and saving log.
 * @author bingyang.djj
 *
 */
public class TmtsLog {
	private static final String LOG_TAG = "TmtsLog";
	private static final String LOG_FILE_EXTENSION = ".html";
	private static final String NEW_LINE = "<br/>";
	private static final String RED_START = "<p style='color:red'>";
	private static final String GREEN_START = "<p style='color:green'>";
	private static final String COLOR_END = "</p>";
	
	/**
	 * Mini space to save log file, 1MB
	 */
	private static final long SAFETY_SPACE = 1;
	private static File normalFile;
    
	/**
	 * Print and save normal log
	 * @param tag Log tag
	 * @param msg message
	 */
    public static void i(String tag, String msg) {
    	Log.i(tag, msg);
    	final StringBuffer log = new StringBuffer();
    	log.append(GREEN_START).append(getlogTime()).append("  ")
    	   .append(getPid()).append("  ")
    	   .append(tag).append("  ")
    	   .append(msg).append(NEW_LINE);
    	
    	new Runnable() {
			
			@Override
			public void run() {
				saveNormalLog(log.append(COLOR_END).toString());
			}
		}.run();
    	
    }
    
    /**
     * @deprecated Use e(String tag, String msg, Throwable e)
     * Print and save error/crash log 
     * @param tag Log tag
     * @param msg Log message
     */
    public static void e(String tag, String msg) {
    	StackTraceElement[] traceElements = new Throwable().getStackTrace();
    	final StringBuffer allLog = new StringBuffer();
    	Log.e(tag, msg);
    	allLog.append(RED_START).append(msg).append(NEW_LINE);
    	
    	//start from 1, we do not need 0
    	for (int i = 1; i < traceElements.length; i++) {
    		Log.e(tag, traceElements[i].toString());
    		allLog.append(traceElements[i].toString())
    		      .append(NEW_LINE);
    	}
    	
    	new Runnable() {
			
			@Override
			public void run() {
				saveNormalLog(allLog.append(COLOR_END).toString());
			}
		}.run();
    	
    }
    
    /**
     * Print and save error/crash log 
     * @param tag Log tag
     * @param msg Log message
     */
    public static void e(String tag, String msg, Throwable e) {
    	StackTraceElement[] traceElements = e.getStackTrace();
    	final StringBuffer allLog = new StringBuffer();
    	Log.e(tag, msg);
    	allLog.append(RED_START).append(msg).append(NEW_LINE);
    	
    	for (int i = 0; i < traceElements.length; i++) {
    		Log.e(tag, traceElements[i].toString());
    		allLog.append(traceElements[i].toString())
    		      .append(NEW_LINE);
    	}
    	
    	new Runnable() {
			
			@Override
			public void run() {
				saveNormalLog(allLog.append(COLOR_END).toString());
			}
		}.run();
    	
    }
    
    /**
     * Get the Sd Root path.
     * @return Sd Root path.
     */
    private static File getSdRootPath() { 
        File sdDir = null;
        
        boolean sdCardExist = Environment.getExternalStorageState()   
                            .equals(android.os.Environment.MEDIA_MOUNTED); 
        
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();
            return sdDir;
            
        } else {
        	Log.i(LOG_TAG, "Sd Card not found");
		}  
        return null; 
    }
    
    /**
     * Get available size of Sd Card.
     * @return Available size of Sd Card in MB.
     */
    private static long getAvailableSize() {
        File path = getSdRootPath();
        if (null == path) {
			return 0;
		}
        
        StatFs stat = new StatFs(path.getPath()); 

        long blockSize = stat.getBlockSize(); 
        long availableBlocks = stat.getAvailableBlocks();

        return (availableBlocks * blockSize) / 1024 / 1024; 
    }
    
    /**
     * Determine whether the Sd Card has enough space to hold log file
     * @return Whether the Sd Card has enough space to hold log file
     */
    private static boolean isEnoughSpace() {
    	return (getAvailableSize() > SAFETY_SPACE) ? true : false;
    }
    
    /**
     * Determine where to save log files
     * @return Root path to save log files
     */
    private static File getRootPath() {
    	return isEnoughSpace() ? getSdRootPath() :  Environment.getDataDirectory();
    }
    
    /**
     * Save crash/error log information to sdcard in html format
     * @param logContent Log content
     */
    private static void saveLogToFile(String logContent) {
    	
    	File directory = new File(getRootPath() + "/TMTS_Log/Error");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        
        if (!isEnoughSpace()) {
			try {
				throw new Exception("There is not enough space in SD Card");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
    	String fileName = directory.getPath() + "/log_" + getTimeStamp() + LOG_FILE_EXTENSION;
    	Log.i(LOG_TAG, "file is " + fileName);
    	
    	FileWriter fwriter = null;
    	
    	try {
    	    fwriter = new FileWriter(fileName);
    	    synchronized (fwriter) {
    	    	fwriter.write(logContent);
			}
    	    
    	} catch (IOException ex) {
    	    ex.printStackTrace();
    	    
    	} finally {
    	    try {
    	    	if (null != fwriter) {
    	    		fwriter.flush();
        	        fwriter.close();
				}
    	        
    	    } catch (IOException ex) {
    	        ex.printStackTrace();
    	    }
        }
    }
    
    /**
     * Save normal log to Sd Card
     * @param logContent Log information
     */
    private static void saveNormalLog(String logContent) {
    	File directory = new File(getRootPath() + "/TMTS_Log/Normal");
    	if (!directory.exists()) {
            directory.mkdirs();
        }
    	
    	if (!isEnoughSpace()) {
			try {
				throw new Exception("There is not enough space in SD Card");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	File file = null;
    	if (null == normalFile) {
    		String fileName = directory.getPath() + "/log_" + getTimeStamp() + LOG_FILE_EXTENSION;
        	file = new File(fileName);
        	normalFile = file;
        	
		} else {
			file = normalFile;
		}
    	
    	FileWriter fwriter = null;
    	
    	try {
    		fwriter = new FileWriter(file, true);
    		synchronized (fwriter) {
    			fwriter.write(logContent);
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
    	    try {
    	    	if (null != fwriter) {
    	    		fwriter.flush();
        	        fwriter.close();
				}
    	        
    	    } catch (IOException ex) {
    	        ex.printStackTrace();
    	    }
        }
    }
    
    /**
     * Get a timestamp used for log file name
     * @return Timestamp
     */
    private static String getTimeStamp() {
    	Calendar now = Calendar.getInstance(); 
    	String timestamp = now.get(Calendar.YEAR) 
    	        + "_" + (now.get(Calendar.MONTH)+1)
    	        + "_" + now.get(Calendar.DAY_OF_MONTH) 
    	        + "_" + now.get(Calendar.HOUR_OF_DAY)
    	        + now.get(Calendar.MINUTE) 
    	        + now.get(Calendar.SECOND)
    	        + now.get(Calendar.MILLISECOND);
    	
    	return timestamp;
    }
    
    /**
     * Get current time used for log
     * @return current time
     */
    private static String getlogTime() {
    	Calendar now = Calendar.getInstance();
    	String logTime = (now.get(Calendar.MONTH)+1)
    	        + "-" + now.get(Calendar.DAY_OF_MONTH)
    	        + " " + now.get(Calendar.HOUR_OF_DAY)
    	        + ":" + now.get(Calendar.MINUTE)
    	        + ":" + now.get(Calendar.SECOND)
    	        + "." + now.get(Calendar.MILLISECOND);
    	
    	return logTime;
    }
    
    /**
     * Get current pid.
     * @return current pid.
     */
    private static String getPid() {
    	return String.valueOf(android.os.Process.myPid());
    }
    
}
