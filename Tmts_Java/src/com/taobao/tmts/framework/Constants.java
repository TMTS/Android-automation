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

/**
 * Constants for TMTS
 * @author bingyang.djj
 *
 */
public class Constants {
	/**
	 * Max time for find a view in milliseconds 
	 */
	public static final int FIND_VIEW_TIME_OUT = 30000;
	
	/**
	 * Time for retry in milliseconds
	 */
	public static final int RETRY_TIME = 500;
	
	/**
	 * ANR time in milliseconds
	 */
	public static final int ANR_TIME = 5000;
	
	/**
	 * Scroll down.
	 */
	static final int DOWN = 0;
	
	/**
	 * Scroll up.
	 */
	static final int UP = 1;
}
