/*
 * Copyright (c) 2012 Yan Pujante
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.linkedin.glu.groovy.utils.collections

import org.linkedin.groovy.util.collections.GroovyCollectionsUtils

/**
 * @author yan@pongasoft.com */
public class GluGroovyCollectionUtils extends GroovyCollectionsUtils
{
  /**
   * The issue with map.subMap(['a', 'b']) is that it will add a 'b' key if not present in
   * original map! The intent of this call is to fix it!
   * @return a new map (always) containing only the keys specified (if they were present in
   * the original map!) or <code>null</code> if <code>map</code> is <code>null</code>
   */
  static Map subMap(Map map, Collection keys)
  {
    if(map == null)
      return null

    if(keys == null)
      keys = []

    Map res = map.subMap(keys)

    keys.each { k ->
      if(!map.containsKey(k))
        res.remove(k)
    }

    return res
  }

  /**
   * Similar to {@link #subMap} but return a map which contains only keys NOT specified in keys
   *
   * @return a new map (alway) containing only the keys NOT specified or <code>null</code> if
   * <code>map</code> is <code>null</code>
   */
  static Map xorMap(Map map, Collection keys)
  {
    if(map == null)
      return null

    if(keys == null)
      keys = []

    def newKeys = new LinkedHashSet(map.keySet())
    newKeys.removeAll(keys)

    subMap(map, newKeys)
  }

  /**
   * Paginates a collection: return how many elements you want (which also represent the number of
   * elements per "page" and an optional offset representing at which "page" to start
   *
   * @return the paginated collection
   */
  static Collection paginate(Collection c, int max, int offset = 0)
  {
    if(c == null)
      return null

    int firstIndex = max * offset
    if(firstIndex >= c.size())
      return []
    int lastIndex = Math.min(firstIndex + max, c.size())

    return c[firstIndex..<lastIndex]
  }
}