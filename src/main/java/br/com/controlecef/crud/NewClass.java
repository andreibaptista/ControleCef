package br.com.controlecef.crud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewClass {

    public NewClass() throws IOException {
        FileWriter fileWriter = null;
        PrintWriter writer = null;
        FileInputStream stream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        
        /*CONFIGURAR ANTES****************************************************************************/
        String CLASSE = "Empresa"; // nome das classe que sera gerada pelo gerador
        String VARIAVEL = "empresa";// modelo de variavel JavaBeans ex: controleAcesso
        String PROJETO = "controlecef";//nome do projeto
        
        /*CONFIGURAR ANTES****************************************************************************/
        
        
        String PROJET_IMPORTS = PROJETO.toLowerCase();
        
        File f = new File("src/main/java/br/com/"+PROJETO+"/crud"); 
        String s = f.getAbsolutePath();
        File caminhoAbsolutoParaTemplates = new File(s);
        
        
        File f2 = new File("src/main/java/br/com/"+PROJET_IMPORTS);
        String CAMINHO_PACOTE = f2.getAbsolutePath();
        
        
        File f3 = new File("src/main/webapp/seg/");
        String CAMINHO_WEB = f3.getAbsolutePath();
        
        new File("src/main/webapp/seg/"+VARIAVEL).mkdirs(); 
        
        String CAMINHO_PACOTE_CONTROL = CAMINHO_PACOTE+"\\control\\";
        String CAMINHO_PACOTE_SERVICO = CAMINHO_PACOTE+"\\service\\";
        String CAMINHO_PACOTE_ITERFACE_SERVICO = CAMINHO_PACOTE+"\\service\\";
        String CAMINHO_PACOTE_ITERFACE_DAO = CAMINHO_PACOTE+"\\dao\\";
        String CAMINHO_PACOTE_DAO = CAMINHO_PACOTE+"\\dao\\";
        String CAMINHO_WEB1 = CAMINHO_WEB+"\\"+VARIAVEL+"\\";
        
        
        String CLASSE_CONTROL = CAMINHO_PACOTE_CONTROL+CLASSE+"Control.java";
        String CLASSE_SERVICO = CAMINHO_PACOTE_SERVICO+CLASSE+"ServiceImpl.java";
        String INTERFACE_SERVICO = CAMINHO_PACOTE_ITERFACE_SERVICO+CLASSE+"Service.java";
        String INTERFACE_DAO = CAMINHO_PACOTE_ITERFACE_DAO+CLASSE+"Dao.java";
        String CLASSE_DAO = CAMINHO_PACOTE_DAO+CLASSE+"DaoImpl.java";
        String PAGINA = CAMINHO_WEB1+VARIAVEL+"-principal.xhtml";
        
        /*key � o nome especifico do template*/
        Map<String,String> t =  new HashMap<String, String>();
        t.put("Control", CLASSE_CONTROL);
        t.put("ServicoImpl", CLASSE_SERVICO);
        t.put("Service", INTERFACE_SERVICO);
        t.put("IDao", INTERFACE_DAO);
        t.put("DaoImpl", CLASSE_DAO);
        t.put("pagina", PAGINA);
        
        for(Map.Entry<String,String> e : t.entrySet()){
            File arquivoSeam = new File(e.getValue()); 
            arquivoSeam.createNewFile();
            
        
	        stream = new FileInputStream(caminhoAbsolutoParaTemplates+"\\template"+e.getKey()+".txt");
	        streamReader = new InputStreamReader(stream);
	        reader = new BufferedReader(streamReader);
        
        
       /*  if(!e.getKey().equals("InterfaceFachada") && !e.getKey().equals("FachadaBean") ){
        	fileWriter =  new FileWriter(e.getValue());
            writer = new PrintWriter(fileWriter);
         }else{*/
        	// tirarChaveFinal(e);
        	/* fileWriter =  new FileWriter(e.getValue(),true);
             writer = new PrintWriter(fileWriter);*/
        // }
        
        fileWriter =  new FileWriter(e.getValue());
        writer = new PrintWriter(fileWriter);
        
        String line = null;
        List<String> arquivo = new ArrayList<String>();
        
        while ((line = reader.readLine()) != null) { 
			arquivo.add(line);
			String tr =  line.replace("CLASSE", CLASSE).replace("VARIAVEL", VARIAVEL).replace("PROJETO", PROJETO).replace("PROJET_IMPORTS", PROJET_IMPORTS);
            writer.println(tr);
        }
        writer.close();
        fileWriter.close();
        reader.close();
        streamReader.close();
        stream.close();

        }
	}
    
    public static void main(String... a) throws IOException{
        new NewClass();
    }   
}
