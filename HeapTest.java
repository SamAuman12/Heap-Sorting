public class HeapTest{

public static void main(String args[]){ 
Integer [] data = {6, 18, 29, 20, 28, 39, 66, 37, 26, 76, 32, 74}; //existing heap
HeapApp a = new HeapApp(data);

System.out.println(a);

String top1 = a.top_value();
System.out.println("Top 1: "+top1);
a.heap_top_remove();
System.out.println("Top 1: "+top1);
System.out.println(a);

String top2 = a.top_value();
a.heap_top_remove();
System.out.println("1st round-off: "+top2);
System.out.println(a);

a.heap_item_add(89);
a.heap_item_add(8);
System.out.println(a);
System.out.println(a.sorted_out());
}
}