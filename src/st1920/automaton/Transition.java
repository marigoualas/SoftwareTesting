/*
 * Original license:
 * 
 * Copyright (c) 2001-2017 Anders Moeller
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package st1920.automaton;

import java.io.Serializable;

/** 
 * <tt>Automaton</tt> transition. 
 * <p>
 * A transition, which belongs to a source state, consists of a Unicode character interval
 * and a destination state.
 * @author Anders M&oslash;ller &lt;<a href="mailto:amoeller@cs.au.dk">amoeller@cs.au.dk</a>&gt;
 */
public class Transition implements Serializable, Cloneable {
	
	static final long serialVersionUID = 40001;
	
	/* 
	 * CLASS INVARIANT: min<=max
	 */
	
	char min;
	char max;
	
	State to;
	
	/** 
	 * Constructs a new singleton interval transition. 
	 * @param c transition character
	 * @param to destination state
	 */
	public Transition(char c, State to)	{
		min = max = c;
		this.to = to;
	}
	
	/** 
	 * Constructs a new transition. 
	 * Both end points are included in the interval.
	 * @param min transition interval minimum
	 * @param max transition interval maximum
	 * @param to destination state
	 */
	public Transition(char min, char max, State to)	{
		if (max < min) {
			char t = max;
			max = min;
			min = t;
		}
		this.min = min;
		this.max = max;
		this.to = to;
	}
	
	/** 
	 * Checks for equality.
	 * @param obj object to compare with
	 * @return true if <tt>obj</tt> is a transition with same 
	 *         character interval and destination state as this transition.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Transition) {
			Transition t = (Transition)obj;
			return t.min == min && t.max == max && t.to == to;
		} else
			return false;
	}
	
	/** 
	 * Returns hash code.
	 * The hash code is based on the character interval (not the destination state).
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		return min * 2 + max * 3;
	}
	
}
