import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionI {
    List<Integer> heap;

    InsertionI(){
        heap = new ArrayList<>();
    }
    int parent(int i) {return (i-1)/2;}
    int leftChild(int i) { return 2*i+1;}
    int rightChild(int i) { return 2*i+2;}

    public void insert(int val){
        heap.add(val);
        int index = heap.size()-1;
        while(index>0 && heap.get(parent(index)) < heap.get(index)){
            Collections.swap(heap, index, parent(index));
            index = parent(index);
        }
    }
    public void heapify(int i){
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if(left<heap.size() && heap.get(left) > heap.get(largest)){
            largest = left;
        }
        if(right<heap.size() && heap.get(right) > heap.get(largest)){
            largest = left;
        }
        if(largest != -1){
            Collections.swap(heap, i, largest);
            heapify(largest);
        }
    }
    public void printHeap(){
        System.out.println(heap);
    }
    public static void main(String[] args) {
        InsertionI maxHeap = new InsertionI();
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.printHeap();
    }
}
