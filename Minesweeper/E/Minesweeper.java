package E;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;



/**
 * Created by LZing on 2017/8/11.
 */

class Mine extends JButton{
    public int x;  //行坐标
    public int y;  //列坐标
    public boolean mine=false;  //是否为地雷
    public int mine_arround=0;  //周围的地雷数目
    public int button_arround=0; //周围未点开方块
    public int flag=0;  //是否做了地雷标记

    public boolean had_num=false;  //是否已经点开有数字
    public boolean had_clicked=false;  //是否已经被点击
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public Mine(int x,int y){   //构造初始化
        this.x=x;
        this.y=y;
    }

}

public class Minesweeper extends JFrame implements ActionListener{
    private Container c;
    private JMenuBar bar;
    private JMenu newgame;
    private JMenuItem easy,middle,hard,about;
    private JTextField mine_count,time_count;
    public int mines;
    private JLabel mine,time;
    private JPanel p1,p2,p3,p;
    private int row=9,column=9;

    public static int flag_count=0;

    public Mine[][] block;
    //public ArrayList<Mine> block;//=new ArrayList<>(400);
    int i=0,j=0;


    public void setRowAndColumn(int row,int column){
        this.row=row;
        this.column=column;
    }
    public void display(){
        System.out.println(row+"   "+column);
    }
    public Minesweeper(){
        super("mine");
    }

    //生成指定数目的地雷
    public void createMine(Mine[][] mine,int row,int column,int seed){
        Random rand=new Random(seed);
        int all,x,y;
        if(row==9)
            all=10;
        else if(row==13)
            all=30;
        else
            all=55;
        mines=all;
        for(int m=0;m<all;m++){
            int temp=rand.nextInt(row*column);
            if(mine[temp/row][temp%column].mine==true)
                m--;     //若有相同位置则-1多加一次循环，确保地雷的数量足够

            mine[temp/row][temp%column].mine=true;

        }
    }

    //获取周围未点开的方块
    public ArrayList<Mine> arround_button(Mine m){
        ArrayList<Mine> arround = new ArrayList<Mine>();
        int x, y;
        x = m.x;
        y = m.y;
       // Map<Integer,ArrayList<Mine>> map=new HashMap<Integer,ArrayList<Mine>>();
        if (x - 1 >= 0 && y - 1 >= 0)//左上角
            if(block[x - 1][y - 1].had_clicked==false&&block[x - 1][y - 1].had_num==false)
                 arround.add(block[x - 1][y - 1]);
        if (x - 1 >= 0)//正上方
            if(block[x - 1][y ].had_clicked==false&&block[x - 1][y].had_num==false)
              arround.add(block[x - 1][y]);
        if (x - 1 >= 0 && y + 1 < column)      //右上角
            if(block[x - 1][y +1].had_clicked==false&&block[x - 1][y + 1].had_num==false)
                arround.add(block[x - 1][y + 1]);
        if (y - 1 >= 0)                        //左边
            if(block[x][y - 1].had_clicked==false&&block[x ][y - 1].had_num==false)
               arround.add(block[x][y - 1]);
        if (y + 1 < column)                    //右边
            if(block[x ][y + 1].had_clicked==false&&block[x ][y +1].had_num==false)
                arround.add(block[x][y + 1]);
        if (x + 1 < row && y - 1 >= 0)         //左下角
            if(block[x +1][y - 1].had_clicked==false&&block[x +1][y - 1].had_num==false)
                arround.add(block[x + 1][y - 1]);
        if (x + 1 < row)                       //正下方
            if(block[x + 1][y].had_clicked==false&&block[x + 1][y].had_num==false)
                arround.add(block[x + 1][y]);
        if (x + 1 < row && y + 1 < column)     //右下角
            if(block[x + 1][y + 1].had_clicked==false&&block[x + 1][y + 1].had_num==false)
                arround.add(block[x + 1][y + 1]);
        for (int len = 0; len < arround.size(); len++) {
            if ((arround.get(len)).mine == true)
                m.mine_arround++;
        }
        m.button_arround=arround.size();
        return arround;
    }

    public void check(Mine M){

        if (M.mine == true) {
            M.setIcon(new ImageIcon(
                    "D:\\projectWork\\Minesweeper\\src\\E\\mine.jpg"));
            JOptionPane.showMessageDialog(null, "Game Over",
                    "Tip", JOptionPane.ERROR_MESSAGE);
        }
        ArrayList<Mine> Abutton=arround_button(M);
        if(M.mine_arround==0) {
            M.setIcon(null);
            for(int len=0;len<M.button_arround;len++)
            {
                if((Abutton.get(len)).had_num==false)
                    check(Abutton.get(len));
            }

        }
        else {
            if(M.had_clicked==false){
                M.setIcon(new ImageIcon(
                        "D:\\projectWork\\Minesweeper\\src\\E\\" + M.mine_arround + ".jpg"));
                M.had_num=true;
                M.had_clicked=true;
            }
        }

    }


    public void init(){

        //block=new ArrayList<Mine>(row*column);
        block=new Mine[row][column];
        c=this.getContentPane();
        bar=new JMenuBar();
        newgame=new JMenu("新游戏");
       // help=new JMenu("帮助");
        easy=new JMenuItem("简单");
        middle=new JMenuItem("中等");
        hard=new JMenuItem("困难");
        about=new JMenuItem("关于");

        easy.addActionListener(this);
        middle.addActionListener(this);
        hard.addActionListener(this);
        about.addActionListener(this);
        newgame.add(easy);
        newgame.add(middle);
        newgame.add(hard);
        bar.setLayout(new FlowLayout());
        bar.add(newgame);
        //bar.add(help);
        bar.add(about);

        mine=new JLabel("雷总数:");
        time=new JLabel("  时间:");
        mine_count=new JTextField(10);
        time_count=new JTextField(10);
        mine_count.setText("20");
        mine_count.setEnabled(false);

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel(new BorderLayout());
        p1.setLayout(new BorderLayout());
        p2.setLayout(new FlowLayout());
        p1.add(bar);
        p2.add(mine);
        p2.add(mine_count);
        p2.add(time);
        p2.add(time_count);
        p3.add(p1,BorderLayout.NORTH);
        p3.add(p2,BorderLayout.CENTER);

        c.setLayout(new BorderLayout());
        // c.add(bar,FlowLayout.LEFT);
        c.add(p3,BorderLayout.NORTH);

        p=new JPanel(new GridLayout(row,column));

        //初始化游戏开始面板
        for(i=0;i<row;i++)
            for(j=0;j<column;j++){
                block[i][j]=new Mine(i,j);
                JButton bt=block[i][j];
                bt.setIcon(new ImageIcon("D:\\projectWork\\Minesweeper\\src\\E\\block.jpg"));
                p.add(bt);
            }
        Calendar time=Calendar.getInstance();
        int second=time.get(Calendar.SECOND);
        createMine(block,row,column,second);
        mine_count.setFont(new Font("宋体",Font.BOLD,20));
        mine_count.setText(String.valueOf(mines));
        //监听器事件处理
       for(i=0;i<row;i++)
           for(j=0;j<column;j++)
               block[i][j].addMouseListener(new MouseListener() {
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       Mine M = (Mine) (e.getSource());
                       if(e.getButton()==MouseEvent.BUTTON3) {
                           if (M.flag == 0){
                               M.setIcon(new ImageIcon(
                                       "D:\\projectWork\\Minesweeper\\src\\E\\flag.jpg"));
                               M.flag=1;
                               flag_count++;
                               if(flag_count==mines)
                                   JOptionPane.showMessageDialog(
                                           null,"Congratulation！You win!","Tip",JOptionPane.ERROR_MESSAGE);

                           }
                           else{
                               M.setIcon(new ImageIcon(
                                       "D:\\projectWork\\Minesweeper\\src\\E\\block.jpg"));
                               M.flag=0;
                               flag_count--;
                           }
                       }
                       else {
                           check(M);
//                               if (M.mine == true) {
//                                   M.setIcon(new ImageIcon(
//                                           "D:\\projectWork\\Minesweeper\\src\\E\\mine.jpg"));
//                                   JOptionPane.showMessageDialog(null, "Game Over",
//                                           "Tip", JOptionPane.ERROR_MESSAGE);
//                               }
//                               else {
//
////                                   ArrayList<Mine> Abutton=arround_button(M);
////
////                                   if (M.mine_arround == 0) {
////                                       M.setIcon(null);
////                                       for(int len=0;len<M.button_arround;len++)
////                                       {
////                                           if((Abutton.get(len)).had_num==false)
////                                              (Abutton.get(len)).setIcon(null);
////                                       }
////
////                                   }
////                                   else {
////                                       if(M.had_clicked==false){
////                                           M.setIcon(new ImageIcon(
////                                                   "D:\\projectWork\\Minesweeper\\src\\E\\" + M.mine_arround + ".jpg"));
////                                            M.had_num=true;
////                                           M.had_clicked=true;
////                                       }
////                                   }//jb.setEnabled(false);
//                                 }
                       }
                   }

                   @Override
                   public void mousePressed(MouseEvent e) {

                   }

                   @Override
                   public void mouseReleased(MouseEvent e) {

                   }

                   @Override
                   public void mouseEntered(MouseEvent e) {

                   }

                   @Override
                   public void mouseExited(MouseEvent e) {

                   }
               });
        c.add(p,BorderLayout.CENTER);
        ArrayList<Mine> mine=new ArrayList<>(50);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(row*40,column*45);
        this.setLocation(800,200);
        this.setVisible(true);
    }

    //关卡难度设置
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==easy)
        {
            setRowAndColumn(9,9);
            c.removeAll();
            init();
            display();

        }
        if(e.getSource()==middle){
            setRowAndColumn(13,13);
            c.removeAll();
            init();
            display();
        }
        if(e.getSource()==hard){
            setRowAndColumn(17,17);
            c.removeAll();
            init();
            display();
        }
        if(e.getSource()==about){
            JOptionPane.showMessageDialog(null,"By LZing in 2017.9",
                    "Author",JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public static void main(String[] args){
      Minesweeper game=new Minesweeper();
      game.init();
    }
}
