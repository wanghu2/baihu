package com.mrwang.baihu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	 //radio
    private RadioButton radio_one;
    private RadioButton radio_two;

    //EditText
    private EditText edit_wha;
    private EditText edit_whb;
    private EditText edit_whc;
    private EditText edit_whd;
    private EditText edit_whe;
    private EditText edit_whf;
    private EditText edit_whg;
    private EditText edit_whh;
    private EditText edit_whi;
    private EditText edit_whj;
    private EditText edit_whk;
    private EditText edit_whl;
    private EditText whm;

    //TextView
    private TextView text_one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;

    //button
    private Button btntwelve;

    //
    int[] L = new int[4];
    int[] J = new int[4];
    int[] W = new int[4];
    int[] js = new int[4];
    int[] SS = new int[4];
    int[] zong = new int[4];
    //int

    private  int check = 0;
    private double whmzhi;


    private void qingling(){

    }


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//定义变量

        //radio
        radio_one = (RadioButton) findViewById(R.id.radio_one);
        radio_two = (RadioButton) findViewById(R.id.radio_two);

        //EditText
        edit_wha = (EditText)findViewById(R.id.edit_wha);
        edit_whb = (EditText)findViewById(R.id.edit_whb);
        edit_whc = (EditText)findViewById(R.id.edit_whc);
        edit_whd = (EditText)findViewById(R.id.edit_whd);
        edit_whe = (EditText)findViewById(R.id.edit_whe);
        edit_whf = (EditText)findViewById(R.id.edit_whf);
        edit_whg = (EditText)findViewById(R.id.edit_whg);
        edit_whh = (EditText)findViewById(R.id.edit_whh);
        edit_whi = (EditText)findViewById(R.id.edit_whi);
        edit_whj = (EditText)findViewById(R.id.edit_whj);
        edit_whk = (EditText)findViewById(R.id.edit_whk);
        edit_whl = (EditText)findViewById(R.id.edit_whl);
        whm = (EditText)findViewById(R.id.edit_whm);

        //TextView
        text_one = (TextView)findViewById(R.id.text_one);
        two = (TextView)findViewById(R.id.text_two);
        three = (TextView)findViewById(R.id.text_three);
        four = (TextView)findViewById(R.id.text_four);
        five = (TextView)findViewById(R.id.text_five);

        //button
        btntwelve = (Button)findViewById(R.id.button);



        //处理按钮点击事件
        radio_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_one.setEnabled(false);
                edit_whj.setEnabled(false);
                edit_whk.setEnabled(false);
                edit_whl.setEnabled(false);
                five.setEnabled(false);
                check = 1;

            }
        });

        radio_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_one.setEnabled(true);
                edit_whj.setEnabled(true);
                edit_whk.setEnabled(true);
                edit_whl.setEnabled(true);
                five.setEnabled(true);
                check = 0;
            }
        });



        btntwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //强转为整形
                L[0] = Integer.parseInt(edit_wha.getText().toString()) ;
                J[0] = Integer.parseInt(edit_whb.getText().toString()) ;
                W[0] = Integer.parseInt(edit_whc.getText().toString()) ;
                L[1] = Integer.parseInt(edit_whd.getText().toString()) ;
                J[1] = Integer.parseInt(edit_whe.getText().toString()) ;
                W[1] = Integer.parseInt(edit_whf.getText().toString()) ;
                L[2] = Integer.parseInt(edit_whg.getText().toString()) ;
                J[2] = Integer.parseInt(edit_whh.getText().toString()) ;
                W[2] = Integer.parseInt(edit_whi.getText().toString()) ;
                whmzhi = Double.parseDouble( whm.getText().toString());
                if(check !=1)
                {
                    L[3] = Integer.parseInt(edit_whj.getText().toString());
                    J[3] = Integer.parseInt(edit_whk.getText().toString());
                    W[3] = Integer.parseInt(edit_whl.getText().toString());
                    for(int s=0;s<4;s++)
                        if(W[s]%10 != 0){
                            if(W[s]%10>=5){
                                W[s]+=(10-W[s]%10);
                            }
                            else W[s]-=W[s]%10;
                        }
                    for(int i=0;i<4;i++)
                    {
                        for(int j=0;j<4;j++)
                        {
                            if(i!=j)
                            {
                                if(J[i]>J[j])
                                {
                                    js[i]+=J[i]+J[j];
                                }
                                else  if(J[i]<J[j])
                                {
                                    js[i]-=J[i]+J[j];
                                }
                                else js[i]=js[i];
                            }
                        }

                    }

                    for(int i=0;i<4;i++)
                    {
                        for(int j=0;j<4;j++)
                        {
                            if(i!=j)
                            {
                                if(W[i]>W[j])
                                {
                                    SS[i]+=(W[i]-W[j])*whmzhi*(L[i]+1)*(L[j]+1);


                                }
                                else if(W[i]<W[j])
                                {
                                    SS[i]-=(W[j]-W[i])*whmzhi*(L[i]+1)*(L[j]+1);
                                }
                                else SS[i]=SS[i];
                            }
                        }

                    }
                    for(int i=0;i<4;i++)
                    {
                        zong[i]=js[i]+SS[i];
                    }
                    two.setText(zong[0]+"");
                    three.setText(zong[1]+"");
                    four.setText(zong[2]+"");
                    five.setText(zong[3]+"");
                    for(int i=0;i<4;i++)
                    {
                        js[i]=0;
                        SS[i]=0;
                    }
                }
                else
                {
                    for(int s=0;s<4;s++)
                        if(W[s]%10 != 0){
                            if(W[s]%10>=5){
                                W[s]+=(10-W[s]%10);
                            }
                            else W[s]-=W[s]%10;
                        }
                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(i!=j)
                            {
                                if(J[i]>J[j])
                                {
                                    js[i]+=J[i]+J[j];

                                }
                                else  if(J[i]<J[j])
                                {
                                    js[i]-=J[i]+J[j];
                                }
                                else js[i]=js[i];
                            }
                        }

                    }

                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(i!=j)
                            {
                                if(W[i]>W[j])
                                {
                                    SS[i]+=(W[i]-W[j])*whmzhi*(L[i]+1)*(L[j]+1);
                                }
                                else if(W[i]<W[j])
                                {
                                    SS[i]-=(W[j]-W[i])*whmzhi*(L[i]+1)*(L[j]+1);
                                }
                                else SS[i]=SS[i];
                            }
                        }

                    }
                    for(int i=0;i<3;i++)
                    {
                        zong[i]=js[i]+SS[i];
                    }
                    two.setText(zong[0]+"");
                    three.setText(zong[1]+"");
                    four.setText(zong[2]+"");
                    for(int i=0;i<3;i++)
                    {
                        js[i]=0;
                        SS[i]=0;
                    }
                }
            }
        });
	}
}