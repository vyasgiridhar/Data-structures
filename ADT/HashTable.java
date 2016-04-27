package ADT;

public class HashTable<D,V> {

    public class Entry<D,V>{

        private D key;
        private V value;

        public Entry(D key,V value){

            this.key = key;
            this.value = value;

        }

        public D 