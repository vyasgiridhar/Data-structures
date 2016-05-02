package Graphs;

import graphs.Vertex.Edge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyList<K>{

	private List<Vertex> vertexList;
	private boolean cycleExists;
	private boolean print;

	public AdjacencyList(){
		this.vertexList = new ArrayList<>();
		this.cycleExists = false;
		this.print = false;
	}

	public void addVertex(K name){
		if (this.findVertex(name) != null){
			System.out.print
		}
	}
	
	public void addEdge(K src,K dest, int weight){
		Vertex x = this.findVertex(src);
		Vertex y = this.findVertex(dest);
		if(x!=null && y!+null){
			if(x.findEdge(y) != null){
				System.out.println("Edge from "+src.toString()+" to "+dest.toString()+" already exists!");
                System.out.println("Updating weight");
                x.updateEdge(y,weight);
			}
		}
		else{
			x.addEdge(y,weight);
		}
	}

	public void removeVertex(K vertex){
        Vertex x = this.findVertex(vertex);
        if(x==null){
            this.missingVertex(vertex);
        }
        else{
            x.removeAllEdges();
            for(Vertex v:this.vertexList){
                if(v.findEdge(x)!=null){
                    v.removeEdge(x);
                }
            }
            this.vertexList.remove(x);
        }
    }
    
    public void removeEdge(K src, K dest){
        Vertex x = this.findVertex(src);
        Vertex y = this.findVertex(dest);
        if(x!= null){
            if(y!=null){
                if(x.findEdge(y)!=null){
                    x.removeEdge(y);
                }
                else{
                    this.missingEdge(src, dest);
                }
            }
            else{
                this.missingVertex(dest);
            }
        }
        else{
            this.missingVertex(src);
        }
    }

    public void updateEdge(K src, K dest, int weight){
        Vertex x = this.findVertex(src);
        Vertex y = this.findVertex(dest);
        if(x!= null){
            if(y!=null){
                if(x.findEdge(y)!=null){
                    x.updateEdge(y, weight);
                }
                else{
                    this.missingEdge(src, dest);
                }
            }
            else{
                this.missingVertex(dest);
            }
        }
        else{
            this.missingVertex(src);
        }
    }
    
    private Vertex findVertex(K name){
        for(Vertex v: this.vertexList){
            if(v.getName().equals(name.toString())){
                return v;
            }
        }
        return null;
    }

    public void printBFS(K source){
    	Vertex src = this.findVertex(source);
        
        if(src==null){
        
            this.missingVertex(source);
            return;
        }
        
        System.out.println("Traversing graph BFS starting from "+src.getName());
        System.out.print(this.traverseBFS(src));
    }

    public String traverseBFS(Vertex src){
    	
    	String BFS = "";
    	Queue<Vertec> q = new LinkedLIst<>();
    	for(Vertex v:this.vertexList){
    		v.unexplore();
    		v.clearDistance();
    		v.clearPredecessor();
    	}
    	src.visit();
    	src.setDistance(0);
    	q.add(src);
    	Vertex current = q.poll();
    	Vertex last = current;
    	while(current!=null){
    		BFS+=current.getName()+"\n";
    		for(Edge e:current.getEdges()){
    			Vertex v = e.getDest();
    			if(!v.visited() || v.getDistance()>current.getDistance()+e.getWeight()){
    				q.add(v);
    				v.visit();
    				v.setPredecessor(current);
    				v.setDistance(current.getDistance()+e.getWeight());
    			}
    		}
    		current.explore();
    		current = q.poll();
    		if(current!=null){
    			last = current;
    		}
    	}	
    return BFS;
    }
    public void printDFS(){
    
        this.print = true;
        this.traverseDFS();
    }
    private void traverseDFS(){
    
        for(Vertex v:this.vertexList){
            v.unexplore();
            v.clearDistance();
            v.clearPredecessor();            
        }
    
        if(this.print)System.out.println("Traversing graph DFS:");
    
        for(Vertex v:this.vertexList){
            if(!v.visited()){
                this.DFS(v);
            }
        }
    
        if(this.print)System.out.println();
    }
    private void DFS(Vertex source){
    	source.visit();
    	if(this.print)System.out.print("("+source.getName()+" ");
    	for(Edge e:source.getEdges()){
    		if(!e.getDest().visited()){
    			this.DFS(e.getDest());
    		}
    		else if(e.getDest().visited() && !e.getDest().explored()){
    			this.cycleExists = true;
    		}
    		else{
    			if(e.getDest().visited()&& e.getDest.explored()){
    				System.out.println("Forward edge exists");
    			}
    		}
    	}
    }
}