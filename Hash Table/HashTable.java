package ADT;

public class HashTable<D,V> {

    public class Entry<D,V>{

        private D key;
        private V value;

        public Entry(D key,V value){

            this.key = key;
            this.value = value;

        }

        public D getKey(){

        	return this.key;
        
        }

        publiv V getValue(){

        	return this.value;
        
        }

        public void updateValue(V value){

        	this.value = value;
        
        }

        public boolean matchBoth(D key, V value){

        	return(this.key==key && this.value == value);
        
        }

        public boolean matchKey(K key){
            
            if(key.getClass()==this.key.getClass()){
            
                if(key instanceof Double || key instanceof Float){
                    return key.toString().equals(this.key.toString());
                }
                else{
                    return key==this.key;
                }
            }
            return false;
        }      

        @Override
        public String toString(){
        	String returnStr = "";

        	if(this.key instanceof String){
        		returnStr += ("\""+ this.key + "\"");
        	}
        	else if(this.key instanceof Character){
        		returnStr +=("'" + this.key + "':");
        	}
            else{
                returnStr += (this.key+": ");
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