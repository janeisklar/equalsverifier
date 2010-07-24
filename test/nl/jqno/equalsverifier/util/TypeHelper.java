/*
 * Copyright 2010 Jan Ouwens
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.jqno.equalsverifier.util;

import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class TypeHelper {
	private static enum Enum { FIRST, SECOND }
	private static final Object OBJECT = new Object();
	
	static final class AllTypesContainer {
		boolean _boolean = false;
		byte _byte = 0;
		char _char = '\u0000';
		double _double = 0.0D;
		float _float = 0.0F;
		int _int = 0;
		long _long = 0L;
		short _short = 0;

		Boolean _Boolean = false;
		Byte _Byte = 0;
		Character _Char = '\u0000';
		Double _Double = 0.0D;
		Float _Float = 0.0F;
		Integer _Int = 0;
		Long _Long = 0L;
		Short _Short = 0;
		
		Enum _enum = Enum.FIRST;
		int[] _array = {1, 2, 3};
		Object _object = OBJECT;
		Class<?> _klass = Class.class;
		String _string = "";
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof AllTypesContainer)) {
				return false;
			}
			AllTypesContainer other = (AllTypesContainer)obj;
			boolean result = true;
			result &= _boolean == other._boolean;
			result &= _byte == other._byte;
			result &= _char == other._char;
			result &= Double.compare(_double, other._double) == 0;
			result &= Float.compare(_float, other._float) == 0;
			result &= _int == other._int;
			result &= _long == other._long;
			result &= _short == other._short;
			result &= _Boolean == other._Boolean;
			result &= _Byte == other._Byte;
			result &= _Char == other._Char;
			result &= (_Double == null || other._Double == null) ?
							_Double == other._Double :
							Double.compare(_Double, other._Double) == 0;
			result &= (_Float == null || other._Float == null) ?
							_Float == other._Float :
							Float.compare(_Float, other._Float) == 0;
			result &= _Int == other._Int;
			result &= _Long == other._Long;
			result &= _Short == other._Short;
			result &= _enum == other._enum;
			result &= Arrays.equals(_array, other._array);
			result &= _object == null ? other._object == null : _object.equals(other._object);
			result &= _klass == other._klass;
			result &= _string == null ? other._string == null : _string.equals(other._string);
			return result;
		}
	}
	
	static final class AllArrayTypesContainer {
		boolean[] booleans = { true };
		byte[] bytes = { 1 };
		char[] chars = { 'a' };
		double[] doubles = { 1.0D };
		float[] floats = { 1.0F };
		int[] ints = { 1 };
		long[] longs = { 1L };
		short[] shorts = { 1 };

		Boolean[] Booleans = { true };
		Byte[] Bytes = { 1 };
		Character[] Characters = { 'a' };
		Double[] Doubles = { 1.0D };
		Float[] Floats = { 1.0F };
		Integer[] Integers = { 1 };
		Long[] Longs = { 1L };
		Short[] Shorts = { 1 };

		Enum[] enums = { Enum.FIRST };
		int[][] arrays = { { 1 } };
		Object[] objects = { OBJECT };
		Class<?>[] classes = { Class.class };
		String[] strings = { "1" };

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof AllArrayTypesContainer)) {
				return false;
			}
			AllArrayTypesContainer other = (AllArrayTypesContainer)obj;
			boolean result = true;
			result &= Arrays.equals(booleans, other.booleans);
			result &= Arrays.equals(bytes, other.bytes);
			result &= Arrays.equals(chars, other.chars);
			result &= Arrays.equals(doubles, other.doubles);
			result &= Arrays.equals(floats, other.floats);
			result &= Arrays.equals(ints, other.ints);
			result &= Arrays.equals(longs, other.longs);
			result &= Arrays.equals(shorts, other.shorts);
			result &= Arrays.equals(Booleans, other.Booleans);
			result &= Arrays.equals(Bytes, other.Bytes);
			result &= Arrays.equals(Characters, other.Characters);
			result &= Arrays.equals(Doubles, other.Doubles);
			result &= Arrays.equals(Floats, other.Floats);
			result &= Arrays.equals(Integers, other.Integers);
			result &= Arrays.equals(Longs, other.Longs);
			result &= Arrays.equals(Shorts, other.Shorts);
			result &= Arrays.equals(enums, other.enums);
			result &= Arrays.deepEquals(arrays, other.arrays);
			result &= Arrays.equals(objects, other.objects);
			result &= Arrays.equals(classes, other.classes);
			result &= Arrays.equals(strings, other.strings);
			return result;
		}
	}
	
	static class RecursiveApiClassesContainer {
		Date date;
		Pattern pattern;
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof RecursiveApiClassesContainer)) {
				return false;
			}
			RecursiveApiClassesContainer other = (RecursiveApiClassesContainer)obj;
			boolean result = true;
			result &= date.equals(other.date);
			result &= pattern.equals(other.pattern);
			return result;
		}
	}
	
	@SuppressWarnings("unchecked")
	static class AllMapImplementationsContainer {
		ConcurrentHashMap concurrentHashMap;
		EnumMap enumMap;
		HashMap hashMap;
		Hashtable hashtable;
		LinkedHashMap linkedHashMap;
		Properties properties;
		TreeMap treeMap;
		WeakHashMap weakHashMap;
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof AllMapImplementationsContainer)) {
				return false;
			}
			AllMapImplementationsContainer other = (AllMapImplementationsContainer)obj;
			boolean result = true;
			result &= concurrentHashMap.equals(other.concurrentHashMap);
			result &= enumMap.equals(other.enumMap);
			result &= hashMap.equals(other.hashMap);
			result &= hashtable.equals(other.hashtable);
			result &= linkedHashMap.equals(other.linkedHashMap);
			result &= properties.equals(other.properties);
			result &= treeMap.equals(other.treeMap);
			result &= weakHashMap.equals(other.weakHashMap);
			return result;
		}
	}

	static interface Interface {}
	
	static abstract class AbstractClass {
		public int i; 
	}
	
	static final class InterfaceContainer {
		public Interface _interface;
	}
	
	static final class AbstractClassContainer {
		public AbstractClass ac;
	}
	
	static final class AbstractAndInterfaceArrayContainer {
		public AbstractClass[] abstractClasses = new AbstractClass[] { null };
		public Interface[] interfaces = new Interface[] { null };
	}

	static final class ObjectContainer {
		public Object _object = new Object();
	}
	
	static final class PrimitiveContainer {
		public int i = 10;
	}
	
	static final class StaticFinalContainer {
		public static final int CONST = 42;
		public static final Object OBJECT = new Object();
	}
}
