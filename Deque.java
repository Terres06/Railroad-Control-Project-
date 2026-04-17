import java.io.Serializable;
class Deque implements Serializable {
   protected int N;          // Guarda o tamanho m�ximo do deque.
   protected Object[] data;  // Guarda os elementos do deque no vetor circular.
   protected int size;       // Guarda a quantidade atual de elementos.
   protected int front;      // Guarda o �ndice do in�cio do deque.
   protected int rear;       // Guarda o �ndice do fim do deque.
   protected int ptr;        // Guarda o ponteiro usado para percorrer o deque.

   public Deque(int N) {
      // Recebe o tamanho m�ximo do deque e inicializa seus dados.
      this.N = N;           // Copia o tamanho m�ximo para o atributo da classe.
      data = new Object[N]; // Cria o vetor que armazenar� os elementos.
      size = 0;             // Define que o deque come�a vazio.
      front = 0;            // Define a posi��o inicial do in�cio do deque.
      rear = 0;             // Define a posi��o inicial do fim do deque.
      ptr = 0;              // Define a posi��o inicial do ponteiro de percurso.
   }

   public boolean isEmpty() {
      // Retorna verdadeiro quando o deque n�o possui elementos.
      return size == 0;    // Compara o tamanho atual com zero.
   }

   public boolean isFull() {
      // Retorna verdadeiro quando o deque atingiu a capacidade m�xima.
      return size == N;    // Compara a quantidade atual com a capacidade m�xima.
   }

   public int getSize() {
      // Retorna a quantidade atual de elementos do deque.
      return size;         // Devolve o valor armazenado em size.
   }

   public Object peekFront() {
      // Retorna o primeiro elemento sem remov�-lo do deque.
      if (isEmpty())       // Verifica se n�o existe elemento no deque.
         return null;      // Retorna null quando o deque est� vazio.
      return data[front];  // Retorna o elemento localizado no in�cio.
   }

   public Object peekRear() {
      // Retorna o �ltimo elemento sem remov�-lo do deque.
      if (isEmpty())       // Verifica se n�o existe elemento no deque.
         return null;      // Retorna null quando o deque est� vazio.
      return data[rear];   // Retorna o elemento localizado no fim.
   }

   public String toString() {
      // Monta e retorna uma string com os elementos do deque em ordem.
      if (isEmpty())       // Verifica se o deque n�o possui elementos.
         return "Deque vazio."; // Retorna mensagem apropriada para deque vazio.
      String lista = "";   // Cria a string que acumular� os elementos.
      rewind();            // Posiciona o ponteiro de percurso no in�cio.
      int strSize = 0;     // Controla quantos elementos j� foram copiados.
      while (strSize < size) { // Repete enquanto faltarem elementos a copiar.
         lista += next().toString(); // Concatena o pr�ximo elemento � string.
         strSize++;        // Incrementa a quantidade de elementos copiados.
         if (strSize < size) // Verifica se ainda faltam elementos.
            lista += " ";  // Acrescenta um espa�o entre os elementos.
      }
      return lista;        // Retorna a string montada com os elementos.
   }

   public void rewind() {
      // Coloca o ponteiro de percurso no in�cio atual do deque.
      ptr = front;         // Faz o ponteiro passar a apontar para o in�cio.
   }

   public Object next() {
      // Retorna o elemento apontado e avan�a o ponteiro no vetor circular.
      if (isEmpty())       // Verifica se o deque n�o possui elementos.
         return null;      // Retorna null quando o deque est� vazio.
      Object e = data[ptr]; // Guarda o elemento apontado atualmente.
      ptr++;               // Avan�a o ponteiro para a pr�xima posi��o.
      if (ptr == N)        // Verifica se o ponteiro ultrapassou o vetor.
         ptr = 0;          // Faz o ponteiro circular para a posi��o zero.
      return e;            // Retorna o elemento que foi guardado.
   }

   public void addFirst(Object e) {
      // Pseudoc�digo:
      // Verifique se o deque est� cheio.
      // Se estiver cheio, informe erro e encerre o programa.
      // Se estiver vazio, reposicione in�cio e fim para o estado inicial.
      // Caso contr�rio, recue o ponteiro de in�cio, circulando se preciso.
      // Insira o elemento na nova posi��o de in�cio.
      // Incremente o tamanho do deque.
   
      //********* COMPLETAR **********
   
      // Adiciona um novo elemento no in�cio do deque.
      if (isFull()) {      // Verifica se n�o h� espa�o para nova inser��o.
         System.out.println("Erro: deque cheio ao adicionar no in�cio.");
                           // Exibe mensagem de erro ao usu�rio.
         System.exit(1);   // Encerra o programa com c�digo de erro.
      }
      if (isEmpty()) {     // Verifica se o deque n�o tem elementos.
         front = rear = 0; // Reposiciona in�cio e fim para o estado inicial.
      } else {            // Executa quando j� existem elementos no deque.
         front--;            // Recua o �ndice do in�cio em uma posi��o.
         if (front == -1)    // Verifica se o �ndice saiu do vetor pela esquerda.
            front = N - 1;   // Faz o �ndice circular para o fim do vetor.
      }
      data[front] = e; // Insere o elemento na nova posi��o de in�cio.
      size++;          // Incrementa a quantidade de elementos do deque.
   }

   public void addLast(Object e) {
      // Pseudoc�digo:
      // Verifique se o deque est� cheio.
      // Se estiver cheio, informe erro e encerre o programa.
      // Se estiver vazio, reposicione in�cio e fim para o estado inicial.
      // Caso contr�rio, avance o ponteiro de fim, circulando se preciso.
      // Insira o elemento na nova posi��o de fim.
      // Incremente o tamanho do deque.
      
      //********* COMPLETAR **********
   
      // Adiciona um novo elemento no final do deque.
      if (isFull()) {      // Verifica se n�o h� espa�o para nova inser��o.
         System.out.println("Erro: deque cheio ao adicionar no fim.");
                           // Exibe mensagem de erro ao usu�rio.
         System.exit(1);   // Encerra o programa com c�digo de erro.
      }
      if (isEmpty()) {      // Verifica se o deque n�o tem elementos.
         front = rear = 0;    // Reposiciona in�cio e fim para o estado inicial.    
      } else {             // Executa quando j� existem elementos no deque.
         rear++;             // Avan�a o �ndice do fim em uma posi��o.
         if (rear == N)      // Verifica se o �ndice saiu do vetor pela direita.
            rear = 0;        // Faz o �ndice circular para a posi��o zero.
      }
      data[rear] = e; // Insere o elemento na nova posi��o de fim.      
      size++;        // Incrementa a quantidade de elementos do deque.
   }

   public Object deleteFirst() {
      // Pseudoc�digo:
      // Verifique se o deque est� vazio.
      // Se estiver vazio, informe erro e encerre o programa.
      // Guarde o elemento do in�cio.
      // Defina a posi��o do in�cio como null.
      // Decremente o tamanho do deque.
      // Se o deque ficou vazio, reposicione in�cio e fim para o estado inicial.
      // Sen�o, avance o ponteiro de in�cio, circulando se preciso. 
      // Retorne o elemento guardado.
   
      //********* COMPLETAR **********
   
      // Remove e retorna o elemento do in�cio do deque.
      if (isEmpty()) {     // Verifica se n�o existe elemento para remover.
         System.out.println("Erro: deque vazio ao remover do in�cio.");
                           // Exibe mensagem de erro ao usu�rio.
         System.exit(1);   // Encerra o programa com c�digo de erro.
      }
      Object e_front = data[front]; // Guarda o elemento localizado no in�cio.
      data[front] = null;  // Define como null a posi��o removida do vetor.
      size--;              // Decrementa a quantidade de elementos do deque.
      if (isEmpty())       // Verifica se o deque ficou vazio.
         front = rear = 0;    // Reposiciona in�cio e fim para o estado inicial.      
      else {               // Se n�o vazio.
         front++;             // Avan�a o �ndice do in�cio em uma posi��o.
         if (front == N)      // Verifica se o �ndice ultrapassou o vetor.
            front = 0;           // Faz o �ndice circular para a posi��o zero.   
      } 
      return e_front;      // Retorna o elemento removido do in�cio.
   }

   public Object deleteLast() {     
      // Pseudoc�digo:
      // Verifique se o deque est� vazio.
      // Se estiver vazio, informe erro e encerre o programa.
      // Guarde o elemento do fim.
      // Defina a posi��o do fim como null.
      // Decremente o tamanho do deque.
      // Se o deque ficou vazio, reposicione in�cio e fim para o estado inicial.
      // Sen�o, recue o ponteiro de fim, circulando se preciso. 
      // Retorne o elemento guardado.     
   
      //********* COMPLETAR **********
   
      // Remove e retorna o elemento do fim do deque.
      if (isEmpty()) {     // Verifica se n�o existe elemento para remover.
         System.out.println("Erro: deque vazio ao remover do fim.");
                           // Exibe mensagem de erro ao usu�rio.
         System.exit(1);   // Encerra o programa com c�digo de erro.
      }
      Object e_rear = data[rear]; // Guarda o elemento localizado no fim.
      data[rear] = null;  // Define como null a posi��o removida do vetor.
      size--;              // Decrementa a quantidade de elementos do deque.   
      if (isEmpty())       // Verifica se o deque ficou vazio.
         front = rear = 0;    // Reposiciona in�cio e fim para o estado inicial.      
      else {               // Se n�o vazio.
         rear--;              // Recua o �ndice do fim em uma posi��o.
         if (rear == -1)      // Verifica se o �ndice saiu do vetor pela esquerda.
            rear = N - 1;        // Faz o �ndice circular para o fim do vetor.  
      }      
      return e_rear;       // Retorna o elemento removido do fim.
   }
}