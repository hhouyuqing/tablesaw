package com.github.lwhite1.outlier.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntCollection;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import java.util.Set;

/**
 * A map that supports reversible key value pairs of short->String
 */
public class DictionaryMap {

  private final Int2ObjectMap<String> keyToValue = new Int2ObjectOpenHashMap<>();

  private final Object2IntMap<String> valueToKey = new Object2IntOpenHashMap<>();

  public void put(int key, String value) {
    keyToValue.put(key, value);
    valueToKey.put(value, key);
  }

  public String get(int key) {
    return keyToValue.get(key);
  }

  public int get(String value) {
    return valueToKey.get(value);
  }

  public void remove(short key) {
    String value = keyToValue.remove(key);
    valueToKey.remove(value);
  }

  public void remove(String value) {
    int key = valueToKey.remove(value);
    keyToValue.remove(key);
  }

  public void clear() {
    keyToValue.clear();
    valueToKey.clear();
  }

  public boolean contains(String stringValue) {
    return valueToKey.containsKey(stringValue);
  }

  public int size() {
    return categories().size();
  }

  public Set<String> categories() {
    return valueToKey.keySet();
  }

  public IntCollection values() {
    return valueToKey.values();
  }

  public Int2ObjectMap<String> keyToValueMap() {
    return keyToValue;
  }

  public Object2IntMap<String> valueToKeyMap() {
    return valueToKey;
  }
}