import java.io.Serializable;

class Deque implements Serializable {
   protected int N;
   protected Object[] data;
   protected int size;
   protected int front;
   protected int rear;
   protected int ptr;

   public Deque(int N) {
      this.N = N;
      data = new Object[N];
      size = 0;
      front = 0;
      rear = 0;
      ptr = 0;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public boolean isFull() {
      return size == N;
   }

   public int getSize() {
      return size;
   }

   public Object peekFront() {
      if (isEmpty())
         return null;
      return data[front];
   }

   public Object peekRear() {
      if (isEmpty())
         return null;
      return data[rear];
   }

   @Override
   public String toString() {
      if (isEmpty())
         return "Deque vazio.";

      String lista = "";
      rewind();
      int strSize = 0;
      while (strSize < size) {
         lista += next().toString();
         strSize++;
         if (strSize < size)
            lista += " ";
      }
      return lista;
   }

   public void rewind() {
      ptr = front;
   }

   public Object next() {
      if (isEmpty())
         return null;
      Object e = data[ptr];
      ptr++;
      if (ptr == N)
         ptr = 0;
      return e;
   }

   public void addFirst(Object e) {
      if (isFull()) {
         System.out.println("Erro: deque cheio ao adicionar no inicio.");
         System.exit(1);
      }
      if (isEmpty()) {
         front = rear = 0;
      } else {
         front--;
         if (front == -1)
            front = N - 1;
      }
      data[front] = e;
      size++;
   }

   public void addLast(Object e) {
      if (isFull()) {
         System.out.println("Erro: deque cheio ao adicionar no fim.");
         System.exit(1);
      }
      if (isEmpty()) {
         front = rear = 0;
      } else {
         rear++;
         if (rear == N)
            rear = 0;
      }
      data[rear] = e;
      size++;
   }

   public Object deleteFirst() {
      if (isEmpty()) {
         System.out.println("Erro: deque vazio ao remover do inicio.");
         System.exit(1);
      }
      Object e_front = data[front];
      data[front] = null;
      size--;
      if (isEmpty())
         front = rear = 0;
      else {
         front++;
         if (front == N)
            front = 0;
      }
      return e_front;
   }

   public Object deleteLast() {
      if (isEmpty()) {
         System.out.println("Erro: deque vazio ao remover do fim.");
         System.exit(1);
      }
      Object e_rear = data[rear];
      data[rear] = null;
      size--;
      if (isEmpty())
         front = rear = 0;
      else {
         rear--;
         if (rear == -1)
            rear = N - 1;
      }
      return e_rear;
   }
}