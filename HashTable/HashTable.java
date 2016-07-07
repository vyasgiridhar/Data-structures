package HashTable;

public class HashTable<D,V> {

    public class Entry<D,V>{

        private D Key;
        private V value;

        public Entry(D Key,V value){

            this.Key = Key;
            this.value = value;

        }

        public D getKey(){

        	return this.Key;
        
        }

        public V getValue(){

        	return this.value;
        
        }

        public void updateValue(V value){

        	this.value = value;
        
        }

        public boolean matchBoth(D Key, V value){

        	return(this.Key==Key && this.value == value);
        
        }

        public boolean matchKey(D Key){
            
            if(Key.getClass()==this.Key.getClass()){
            
                if(Key instanceof Double || Key instanceof Float){
                    return Key.toString().equals(this.Key.toString());
                }
                else{
                    return Key==this.Key;
                }
            }
            return false;
        }      

        @Override
        public String toString(){
        	String returnStr = "";

        	if(this.Key instanceof String){
        		returnStr += ("\""+ this.Key + "\"");
        	}
        	else if(this.Key instanceof Character){
        		returnStr +=("'" + this.Key + "':");
        	}
            else{
                returnStr += (this.Key+": ");
            }
            if(this.value instanceof String){
                returnStr += ("\""+this.value+"\"");
            }
            else if(this.value instanceof Character){
                returnStr += ("'"+this.value+"'");
            }
            else{
                returnStr += this.value;
            }            
            return returnStr;
        }

    }
}
