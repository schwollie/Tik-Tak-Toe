package com.example.maus.tik_tak_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int round = 1;
    int erster = 1;

    private int[][] field = new int[][]  {
        {0,0,0},
        {0,0,0},
        {0,0,0}
    };
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    private TextView txt9;


    private int winner(int[][] field) {
        // Waagrechte Zeilen
        for (int row = 0; row < 3; row++) {
            int summe = 0;
            for (int col = 0; col < 3; col++) {
                summe += field[row][col];
            }
            if (summe == 3) return 1;
            if (summe == -3) return -1;
        }

        // Senkrechte Spalten
        for (int col = 0; col < 3; col++) {
            int summe = 0;
            for (int row = 0; row < 3; row++) {
                summe += field[row][col];
            }
            if (summe == 3) return 1;
            if (summe == -3) return -1;
        }

        // Diagonalen
        int diag1_summe = field[0][0] + field[1][1] + field[2][2];
        if (diag1_summe == 3) return 1;
        if (diag1_summe == -3) return -1;

        int diag2_summe = field[0][2] + field[1][1] + field[2][0];
        if (diag2_summe == 3) return 1;
        if (diag2_summe == -3) return -1;

        return 0;
    }

    private void showField() {
        txt1.setText(getCharacter(field[0][0]));
        txt2.setText(getCharacter(field[0][1]));
        txt3.setText(getCharacter(field[0][2]));
        txt4.setText(getCharacter(field[1][0]));
        txt5.setText(getCharacter(field[1][1]));
        txt6.setText(getCharacter(field[1][2]));
        txt7.setText(getCharacter(field[2][0]));
        txt8.setText(getCharacter(field[2][1]));
        txt9.setText(getCharacter(field[2][2]));
    }

    private String getCharacter(int fieldValue) {
        switch (fieldValue) {
            case -1:
                return "O";
            case 1:
                return "X";
            case 3:
                return "-";
        }
        return "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiktaktoe);

        txt1 = (TextView)findViewById(R.id.t2);
        txt2 = (TextView)findViewById(R.id.t3);
        txt3 = (TextView)findViewById(R.id.t4);
        txt4 = (TextView)findViewById(R.id.t5);
        txt5 = (TextView)findViewById(R.id.t6);
        txt6 = (TextView)findViewById(R.id.t7);
        txt7 = (TextView)findViewById(R.id.t8);
        txt8 = (TextView)findViewById(R.id.t9);
        txt9 = (TextView)findViewById(R.id.t10);

        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt3.setOnClickListener(this);
        txt4.setOnClickListener(this);
        txt5.setOnClickListener(this);
        txt6.setOnClickListener(this);
        txt7.setOnClickListener(this);
        txt8.setOnClickListener(this);
        txt9.setOnClickListener(this);

        anfang();
    }

    public void anfang() {

        showField();
        switch(erster) {
            case 0:
                Toast.makeText(getApplicationContext(), "Das spiel startet nun!" , Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Der Computer Beginnt!: " , Toast.LENGTH_SHORT).show();
            case 1:

                Toast.makeText(getApplicationContext(), "Das spiel startet nun!" , Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Bitte gebe nun dein Startkästchen an: " , Toast.LENGTH_SHORT).show();
        }
        switch(erster) {
            case 0:

                computer1(field);
            case 1:
                spieler1();
        }



    }


    public void spieler1() {
        showField();

    }

    public void computer1(int[][] field) {



        if(erster==0) {
            Random rnd = new Random();
            int ob = rnd.nextInt(5);
            if(ob==0) {
                int ywhere = rnd.nextInt(3);
                int xwhere = rnd.nextInt(3);
                field[ywhere][xwhere] = -1;
                showField();
                round=1;
                spieler1();
            } else if(ob!=0) {
                int ywhere = rnd.nextInt(3);
                int xwhere = rnd.nextInt(3);
                field[ywhere][xwhere] = -1;
                if(ywhere==1&&xwhere==1) {
                    field[0][0]=-1;
                    round=1;
                    showField();
                    spieler1();
                }
            }

        }
    }

    public void computer(int[][] field) {

        int field11 = field[1][1];
        if(field11==0&&erster==1&&field11==0) {
            field[1][1] = -1;
            round = 1;
            showField();
            spieler1();
        }

        for(int row = 0;row > 3;row++) {
            int summe = 0;
            for(int col = 0;col>3;row++) {
                summe += field[row][col];
            }
            if(summe==2) {
                for(int anzahl=0;anzahl<3;anzahl++) {
                    if(field[row][anzahl]==0) {
                        field[row][anzahl]=-1;
                        showField();
                        round=1;
                        spieler1();

                    }

                }
            }

        }

        for(int row = 0;row > 3;row++) {
            int summe = 0;
            for(int col = 0;col>3;col++) {
                summe += field[row][col];
            }
            if(summe==2) {
                for(int anzahl=0;anzahl<3;anzahl++) {
                    if(field[row][anzahl]==0) {
                        field[row][anzahl]=-1;
                        showField();
                        round=1;
                        spieler1();

                    }

                }
            }

        }
        for(int col = 0;col > 3;col++) {
            int summe = 0;
            for(int row = 0;row>3;row++) {
                summe += field[row][col];
            }
            if(summe==2) {
                for(int anzahl=0;anzahl<3;anzahl++) {
                    if(field[anzahl][col]==0) {
                        field[anzahl][col]=-1;
                        showField();
                        round=1;
                        spieler1();

                    }

                }
            }

        }

        for(int row = 0;row > 3;row++) {
            int summe = 0;
            for(int col = 0;col>3;col++) {
                summe += field[row][col];
            }
            if(summe==-2) {
                for(int anzahl=0;anzahl<3;anzahl++) {
                    if(field[row][anzahl]==0) {
                        field[row][anzahl]=-1;
                        showField();
                        round=1;
                        spieler1();

                    }

                }
            }

        }
        for(int col = 0;col > 3;col++) {
            int summe = 0;
            for(int row = 0;row>3;row++) {
                summe += field[row][col];
            }
            if(summe==-2) {
                for(int anzahl=0;anzahl<3;anzahl++) {
                    if(field[anzahl][col]==0) {
                        field[anzahl][col]=-1;
                        showField();
                        round=1;
                        spieler1();

                    }

                }
            }

        }












        showField();

    }







    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.t2&&round==1&&field[0][0]==0) {
            field[0][0] = 1;
            showField();
            round = 0;
            computer(field);
        }

        if(view.getId()==R.id.t3&&round==1&&field[0][1]==0) {
            field[0][1] = 1;
            showField();

            round = 0;

            computer(field);
        }

        if(view.getId()==R.id.t4&&round==1&&field[0][2]==0) {
            field[0][2] = 1;
            showField();
            round = 0;

            computer(field);
        }

        if(view.getId()==R.id.t5&&round==1&&field[1][0]==0) {
            field[1][0] = 1;
            showField();

            round = 0;

            computer(field);
        }

        if(view.getId()==R.id.t6&&round==1&&field[1][1]==0) {
            field[1][1] = 1;
            showField();

            round = 0;

            computer(field);
        }

        if(view.getId()==R.id.t7&&round==1&&field[1][2]==0) {
            field[1][2] = 1;
            showField();

            round = 0;

            computer(field);
        }

        if(view.getId()==R.id.t8&&round==1&&field[2][0]==0) {
            field[2][0] = 1;
            showField();

            round = 0;

            computer(field);
        }
        if(view.getId()==R.id.t9&&round==1&&field[2][1]==0) {
            field[2][1] = 1;
            showField();

            round = 0;

            computer(field);
        }

        if(view.getId()==R.id.t10&&round==1&&field[2][2]==0) {
            field[2][2] = 1;
            showField();

            round = 0;
            computer(field);
        }
    }





}
