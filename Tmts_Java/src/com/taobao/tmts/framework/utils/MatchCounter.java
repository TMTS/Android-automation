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
package com.taobao.tmts.framework.utils;

/**
 * This class contains methods for counting matches, retrieving the count and
 * reseting the counter.
 * 
 * @author Renas Reda, renas.reda@jayway.com
 * 
 */

class MatchCounter {

	private int totalAmountOfMatches;

	/**
	 * Constructs this object.
	 * 
	 */
	public MatchCounter() {
		totalAmountOfMatches = 0;
	}

	/**
	 * Resets the counter.
	 * 
	 */
	public void resetCount() {
		totalAmountOfMatches = 0;
	}

	/**
	 * Adds 1 to the counter.
	 * 
	 */
	public void addMatchToCount() {
		totalAmountOfMatches++;
	}

	/**
	 * Adds number to the counter.
	 * 
	 * @param numberOfMatches
	 *            the number to add to the counter
	 * 
	 */
	public void addMatchesToCount(int numberOfMatches) {

		totalAmountOfMatches += numberOfMatches;

	}

	/**
	 * Returns the total count.
	 * 
	 * @return the total count
	 * 
	 */
	public int getTotalCount() {
		return totalAmountOfMatches;
	}

}
