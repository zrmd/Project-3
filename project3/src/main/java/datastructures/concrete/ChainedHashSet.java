package datastructures.concrete;

import datastructures.concrete.dictionaries.ChainedHashDictionary;
import datastructures.interfaces.IDictionary;
import datastructures.interfaces.ISet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * See ISet
 *  for more details on what each method is supposed to do.
 */
public class ChainedHashSet<T> implements ISet<T> {
    // This should be the only field you need
    private IDictionary<T, Boolean> map;

    public ChainedHashSet() {
        // No need to change this method
        this.map = new ChainedHashDictionary<>();
    }

    
    public void add(T item) {
        this.map.put(item, true);
    }

    
    public void remove(T item) {
        if (this.map.containsKey(item)) {
            this.map.remove(item);
        }else {
            throw new NoSuchElementException();
        }
    }

   
    public boolean contains(T item) {
        return this.map.containsKey(item);
    }

    
    public int size() {
        return this.map.size();
    }

    
    public Iterator<T> iterator() {
        return new SetIterator<>(this.map.iterator());
    }

    private static class SetIterator<T> implements Iterator<T> {
        // This should be the only field you need
        private Iterator<KVPair<T, Boolean>> iter;

        public SetIterator(Iterator<KVPair<T, Boolean>> iter) {
            // No need to change this method.
            this.iter = iter;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public T next() {
            return iter.next().getKey();
        }
    }
}
