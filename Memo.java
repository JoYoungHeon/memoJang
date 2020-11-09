package ddd;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.border.Border;

public class Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Frame ���� �� �߰�
	    // Frame ���� ����ǥ���ٿ� �޸����� ǥ�õǵ��� �մϴ�.
	    JFrame frame = new JFrame("�޸���");
	    
	    // Frame�� ����� �������� ���ϵ��� �մϴ�.
	    //frame.setResizable(false);
	        
	    // â�� ������ ���α׷��� ����ǵ��� �մϴ�.
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	 
	    // �г� ���� �� �߰�
	    // �г� ��ü�� ����. (�ؽ�Ʈ ����)
	    JPanel textPanel = new JPanel();  
	    JPanel alarmPanel = new JPanel();
	    
	    
	    alarmPanel.setToolTipText("��Ÿ ����� ���� �̿��ϴ� �κ��Դϴ�.");
	    
	    //�� �Ʒ� �г��� ������ Ȯ���ϱ� ���ؼ� �гο� ������ �־���.
	    textPanel.setBackground(Color.gray);
	    alarmPanel.setBackground(Color.pink);
	    
	    //frame �������ϰ�� �ټ� �������� �������� �� ���ʿ� textPanel�� ���� �ֽ��ϴ�.
	    frame.getContentPane().add(textPanel, "North");
	    frame.getContentPane().add(alarmPanel, "South");
	    
	    // TextArea�� content�� ����Ű�� ���ڿ��� ǥ���ϰ� 40��, 50���� �����մϴ�.      
	    JTextArea ta = new JTextArea(content, 40, 50); 
	 
	    //�� �ѱ�� ��� �ѱ�
	    ta.setLineWrap(true);
	    
	    //�� �ѱ� �� ���� ������ �ܾ ���࿡ ���� ������ �ʵ��� �ϱ�
	    ta.setWrapStyleWord(true);
	    
	    // ��������
	    ta.setToolTipText("�̰��� �ؽ�Ʈ�� �Է��ϼ���");
	    
	    // TextArea�� �׵θ����� ���� ���� �α��� 3px�� �����մϴ�.
	    Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
	    
	    // �ؽ�Ʈ�� TextArea ��� ���̿� ������ �α� ���ؼ� emptyBorder�� �����մϴ�. 
	    Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
	    
	    //TextArea�� lineBorder(�����׵θ�), emptyBorder(����)�� ������ ���� ��輱�� �����մϴ�.
	    ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
	 
	    // TextArea�� ��ũ�� ����� �߰��� �� Panel�ȿ� ���� �ֽ��ϴ�.
	    textPanel.add(new JScrollPane(ta));
	 
	    
	 
	 
	    
	    
	    // �޴���
	    JMenuBar menuBar = new JMenuBar();
	    
	    // �޴�
	    JMenu fileMenu = new JMenu("����");
	    JMenu findMenu = new JMenu("ã��/�ٲٱ�");
	    
	    // �޴� ������ ������ �غ�
	    JMenuItem newItem = new JMenuItem("�� ����");
	    JMenuItem openItem = new JMenuItem("����");
	    JMenuItem saveItem = new JMenuItem("����");
	    JMenuItem saveasItem = new JMenuItem("�ٸ� �̸����� ����");
	    JMenuItem closeItem = new JMenuItem("�ݱ�");
	 
	    JMenuItem findItem = new JMenuItem("ã��");
	    JMenuItem replaceItem = new JMenuItem("�ٲٱ�"); 
	 
	    frame.setJMenuBar(menuBar);
	 
	    menuBar.add(fileMenu); // ����
	    menuBar.add(findMenu); // ã��/�ٲٱ�
	    fileMenu.add(newItem); // �� ����
	    fileMenu.add(openItem); // ����
	    fileMenu.add(saveItem); // ����
	    fileMenu.add(saveasItem); // �ٸ� �̸����� ����
	    fileMenu.add(closeItem); // �ݱ�
	 
	    findMenu.add(findItem); // ã��
	    findMenu.add(replaceItem); // �ٲٱ�
	    
	    
	    // �ؽ�Ʈ �ʵ带 �����Ѵ�.(�ܾ� ã�� ���� �Է� ����)
	    JTextField searchtext = new JTextField(10);
	    // �˶� �гκκп� searchtext �ؽ�Ʈ �ʵ带 �ִ´�.
	    alarmPanel.add(searchtext);    
	    // ã�� ��ư�� �����Ѵ�.
	    JButton btn1 = new JButton("ã��");
	    alarmPanel.add(btn1);
	    
	 
	    // �ؽ�Ʈ �ʵ带 �����Ѵ�.(�ܾ� �ٲٱ� ���� �Է� ����)
	    JTextField replacetext = new JTextField(10);
	    
	    // �˶� �гκκп� replacetext �ؽ�Ʈ �ʵ带 �ִ´�.
	    alarmPanel.add(replacetext);            
	 
	    // ã�� ��ư�� �����Ѵ�.
	    JButton btn2 = new JButton("�ٲٱ�");
	    alarmPanel.add(btn2);
	    
	    
	    // ��� ������ �����Ѵ�.
	    JTextArea tf = new JTextArea("", 10,40);
	    // ��� ������ �˶� �гο� �ִ´�.
	    alarmPanel.add(tf);
	    // ������ ���ϵ��� �Ѵ�.
	    tf.setEditable(false);
	 
	    //�� �ѱ�� ��� �ѱ�
	    tf.setLineWrap(true);
	 
	    // TextArea�� ��ũ�� ����� �߰��� �� Panel�ȿ� ���� �ֽ��ϴ�.
	    JScrollPane alarmscroll = (JScrollPane) alarmPanel.add(new JScrollPane(tf));
	      
	       
	    // ������ ���� � ������� �̿��ϴ°����� �˷��ش�.
	    tf.setToolTipText("ã�� ����� �̿��� ����� Ȯ�� �� �� �ֽ��ϴ�.");
	    searchtext.setToolTipText("ã�� ����� �̿��� �� �ֽ��ϴ�.");
	    replacetext.setToolTipText("�ٲٱ� ����� �̿��� �� �ֽ��ϴ�.");
	    tf.setVisible(false);
	    searchtext.setVisible(false);
	    replacetext.setVisible(false);
	    btn1.setVisible(false);
	    btn2.setVisible(false);
	    alarmscroll.setVisible(false);
	    tf.setVisible(false);
	  
	    FileDialog mSave = new FileDialog(frame,"����",FileDialog.SAVE);  
	    FileDialog mOpen = new FileDialog(frame,"����",FileDialog.LOAD); 
	    
	    
	    newItem.addActionListener(new ActionListener(){
	    
	        public void actionPerformed(ActionEvent e){
	            ta.setText(content);
	            frame.setTitle("�޸���");
	            flag = 0;
	            frame.setSize(600,810);
	        }
	    });  
	    
	    openItem.addActionListener(new ActionListener(){
	        
	        @Override
	        public void actionPerformed(ActionEvent e){
	            mOpen.setVisible(true); 
	            String data = mOpen.getDirectory()+ mOpen.getFile();
	            try{
	             String str="";
	             FileReader fr = new FileReader(data);
	             BufferedReader br = new BufferedReader(fr);
	            
	            
	             ta.setText("");  // �ϴ� �ʱ�ȭ
	             while((str=br.readLine()) != null){   // str�� ���Ƶ� ������ null �� �ƴϸ�..
	                
	                 ta.append(str);  // str�� ������ �߰�
	                 ta.append("\r\n"); // readline�� ������ ���ϴ� ������� �������ش�.
	             }
	            
	             br.close();
	             String Filename = mOpen.getFile();
	             frame.setTitle(Filename);
	             flag = 1;
	            } catch(Exception e1){
	            }
	        }
	 
	 
	    });  
	    
	    saveItem.addActionListener(new ActionListener(){
	        
	        @Override
	        public void actionPerformed(ActionEvent e){
	            
	            if(flag == 0)
	            {
	                mSave.setVisible(true);
	                String data = mSave.getDirectory()+ mSave.getFile();  // ������ ���丮 ������ ���ϸ��� ��´�.
	                try{
	                    FileWriter fw = new FileWriter(data+".txt"); // txt���Ϸ� �����Ѵ�.  
	                    BufferedWriter bw = new BufferedWriter(fw);
	             
	                    String str = ta.getText();
	                    for(int i = 0 ; i < str.length(); i++)
	                    {
	                        if(str.charAt(i) == '\n')
	                        {
	                            System.out.println("find");
	                            bw.newLine();
	                        }
	                        else
	                            bw.write(str.charAt(i));  // Textarea �� bw��ü�� �ִ� ������ �ִ´�.
	                    }
	                    
	                    bw.close();
	                    String Filename = mSave.getFile();  // ������ ������ �̸��� �ְ�..
	                    frame.setTitle(Filename + ".txt");  // ������ ���� ���ϸ����� �ٲ۴�..
	                }catch(Exception e1){
	 
	                }
	                flag = 1;
	            }
	            
	            else if(flag == 1)
	            {
	                String data = mSave.getDirectory()+ mSave.getFile();  // ������ ���丮 ������ ���ϸ��� ��´�.
	            
	                try{
	                FileWriter fw = new FileWriter(data+".txt"); // txt���Ϸ� �����Ѵ�.  
	                BufferedWriter bw = new BufferedWriter(fw);
	 
	                String str = ta.getText();
	                for(int i = 0 ; i < str.length(); i++)
	                {
	                    if(str.charAt(i) == '\n')
	                    {
	                        System.out.println("find");
	                        bw.newLine();
	                    }
	                    else
	                        bw.write(str.charAt(i));  // Textarea �� bw��ü�� �ִ� ������ �ִ´�.
	                }
	                            bw.close();            
	                }catch(Exception e2){
	                    
	                }
	                
	            }
	 
	        }
	    });  
	    
	    saveasItem.addActionListener(new ActionListener(){
	        
	           @Override
	        public void actionPerformed(ActionEvent e){
	             mSave.setVisible(true);
	             String data = mSave.getDirectory()+ mSave.getFile();  // ������ ���丮 ������ ���ϸ��� ��´�.
	             try{
	              FileWriter fw = new FileWriter(data+".txt"); // txt���Ϸ� �����Ѵ�.  
	              BufferedWriter bw = new BufferedWriter(fw);
	             
	                String str = ta.getText();
	                for(int i = 0 ; i < str.length(); i++)
	                {
	                    if(str.charAt(i) == '\n')
	                    {
	                        System.out.println("find");
	                        bw.newLine();
	                    
	                    }
	                    else
	                        bw.write(str.charAt(i));  // Textarea �� bw��ü�� �ִ� ������ �ִ´�.
	                }
	                
	              bw.close();
	              String Filename = mSave.getFile();  // ������ ������ �̸��� �ְ�,
	              frame.setTitle(Filename + ".txt");  // ������ ���� ���ϸ����� �ٲ۴�.
	             }catch(Exception e1){
	 
	             }
	 
	 
	        }
	    });  
	        
	    closeItem.addActionListener(new ActionListener(){
	        
	        public void actionPerformed(ActionEvent e){
	            System.exit(0);
	        }
	    }); 
	    
	    
	    findItem.addActionListener(new ActionListener(){
	        
	        @Override
	        public void actionPerformed(ActionEvent e){
	            
	          // ������ ����� �ø���.
	          frame.setSize(800,1000);
	          searchtext.setVisible(true);
	          btn1.setVisible(true);
	          
	          replacetext.setVisible(false);
	          btn2.setVisible(false);
	          
	          tf.setVisible(true);
	          tf.setEditable(false);
	          alarmscroll.setVisible(true);
	 
	          btn1.addActionListener(new ActionListener(){
	              public void actionPerformed(ActionEvent e){
	 
	                  
	                  // ã�� �ܾ �����´�.                  
	                  String find = searchtext.getText();
	                  
	                  // �޸����� ������ �����´�.
	                  String str = ta.getText();
	                  
	                  // �ܾ ����ų ��ġ�� ù �κ��� pos�� ���Ѵ�.
	                  pos = str.indexOf(find, fromindex);
	                  
	                  // ���� ������ ã�Ҵٸ� 0���� �ٽ� ã���� �ѹ��� ��ȸ�ش�.
	                  if(pos == -1)
	                  {
	                      pos = 0;
	                      fromindex = 0;
	                      pos = str.indexOf(find,  fromindex);
	                      tf.append("�ܾ ��� ã�ҽ��ϴ�. ó������ �ܾ ã���ϴ�.\r\n" + find + " �ܾ��� ��ġ :: " + pos );
	                      tf.append("\r\n");
	                      fromindex = pos + find.length();
	                      
	                  }
	                  
	                  else
	                  {
	                      fromindex = pos + find.length();
	 
	                      tf.append(find + " �ܾ��� ��ġ :: " + pos );
	                      tf.append("\r\n");
	                  } 
	              
	              }
	              
	          });
	        }
	            
	    });  
	    
	    replaceItem.addActionListener(new ActionListener(){
	        
	        @Override
	        public void actionPerformed(ActionEvent e){
	            
	          // ������ ����� �ø���.
	          frame.setSize(800,1000);
	          
	          searchtext.setVisible(true);
	          btn1.setVisible(true);
	          
	          replacetext.setVisible(true);
	          btn2.setVisible(true);
	          
	          tf.setVisible(true);
	          tf.setEditable(false);
	          alarmscroll.setVisible(true);
	          
	          btn1.addActionListener(new ActionListener(){
	              public void actionPerformed(ActionEvent e){
	 
	                  
	                  // ã�� �ܾ �����´�.                  
	                  String find = searchtext.getText();
	                  
	                  // �޸����� ������ �����´�.
	                  String str = ta.getText();
	                  
	                  // �ܾ ����ų ��ġ�� ù �κ��� pos�� ���Ѵ�.
	                  pos = str.indexOf(find, fromindex);
	                  
	                  // ���� ������ ã�Ҵٸ� 0���� �ٽ� ã���� �ѹ��� ��ȸ�ش�.
	                  if(pos == -1)
	                  {
	                      pos = 0;
	                      fromindex = 0;
	                      pos = str.indexOf(find,  fromindex);
	                      tf.append("�ܾ ��� ã�ҽ��ϴ�. ó������ �ܾ ã���ϴ�.\r\n" + find + " �ܾ��� ��ġ :: " + pos );
	                      tf.append("\r\n");
	                      fromindex = pos + find.length();
	                      
	                  }
	                  
	                  else
	                  {
	                      fromindex = pos + find.length();
	                    
	                      tf.append(find + " �ܾ��� ��ġ :: " + pos );
	                      tf.append("\r\n");
	                  } 
	              
	              }
	              
	          });
	          
	          
	          btn2.addActionListener(new ActionListener(){
	              public void actionPerformed(ActionEvent e){
	 
	                  
	                  // ã�� �ܾ �����´�.                  
	                  String find = searchtext.getText();
	                  String replace = replacetext.getText();
	                  
	                  // �޸����� ������ �����´�.
	                  String str = ta.getText();
	                  
	                  // �ܾ ����ų ��ġ�� ù �κ��� pos�� ���Ѵ�.
	                  pos = str.indexOf(find, fromindex);
	                  
	                  // ���� ������ ã�Ҵٸ� 0���� �ٽ� ã���� �ѹ��� ��ȸ�ش�.
	                  if(pos == -1)
	                  {
	                      pos = 0;
	                      fromindex = 0;
	                      tf.append("������ ��ġ���� �ܾ ��� �ٲپ����ϴ�. \r\n���� �����ִٸ� �ٲٱ� ��ư�� �ٽ� �����ð�, ó������ �ٽ� �˻��Ͽ� �ٲߴϴ�.\r\n");      
	                      tf.append("\r\n");
	                  }
	                  
	                  else
	                  {
	                    fromindex = pos + find.length();
	                    ta.replaceRange(replace, pos, pos+find.length());
	                      tf.append(find + " �ܾ��� ��ġ :: " + pos );
	                      tf.append("\r\n");
	                  } 
	              
	              }
	              
	          });
	                
	        }
	            
	    });  
	    
	    // frame �ȿ� �ִ� ��� ������� ���̵��� frame ����� �����մϴ�.
	    frame.pack();
	        
	    // frame�� ���̵��� �����մϴ�.  
	    frame.setVisible(true);
	  }
	    static String content = "";
	    static int flag = 0; // ����  ��  �ٸ� �̸����� ���忡 �̿�
	    
	    static int pos = 0;
	    static int fromindex = 0;
	

	}


