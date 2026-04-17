import java.io.*;

public class ObjetoPersistente implements Serializable {
   private final String nomeArquivo;

   public ObjetoPersistente(String nomeArquivo) {
      this.nomeArquivo = nomeArquivo;
   }

   public String getCaminhoAbsoluto() {
      File arq = new File(nomeArquivo);
      return arq.getAbsolutePath();
   }

   public boolean existeArquivo() {
      File arq = new File(nomeArquivo);
      return arq.exists() && arq.isFile();
   }

   public boolean salvar(Object obj) {
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
         out.writeObject(obj);
         out.flush();
         System.out.println("Dados salvos no arquivo: " + nomeArquivo + ".");
         return true;
      } catch (Exception e) {
         System.out.println("Erro ao salvar no arquivo: " + nomeArquivo + ".");
         System.out.println("Motivo: " + e.getClass().getSimpleName() + " - " + e.getMessage());
         return false;
      }
   }

   public Object carregar() {
      if (!existeArquivo()) {
         System.out.println("Arquivo inexistente: " + nomeArquivo + ".");
         System.out.println("Caminho esperado: " + getCaminhoAbsoluto());
         return null;
      }

      try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
         Object obj = in.readObject();
         System.out.println("Dados carregados do arquivo: " + nomeArquivo + ".");
         return obj;
      } catch (Exception e) {
         System.out.println("Erro ao carregar o arquivo: " + nomeArquivo + ".");
         System.out.println("Motivo: " + e.getClass().getSimpleName() + " - " + e.getMessage());
         return null;
      }
   }
}