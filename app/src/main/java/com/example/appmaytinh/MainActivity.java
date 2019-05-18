package com.example.appmaytinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnCong, btnTru, btnNhan, btnChia, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDelete, btnCham, btnBang;
    Button.OnClickListener suKienAnNut, suKienAnXoa, suKienTinhToan, suKienDauBang;
    EditText edtDuLieu;

    int []dsIDButton = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnCong, R.id.btnTru, R.id.btnNhan, R.id.btnChia, R.id.btnDelete, R.id.btnCham, R.id.btnBang};
    //Button []dsButton;
    Button button;
    String phepToan = "";
    double soThuNhat, soThuHai, ketQua;

    public void addControls()
    {
        edtDuLieu = findViewById(R.id.edtDuLieu);
/*        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnDelete = findViewById(R.id.btnDelete);
        btnCham = findViewById(R.id.btnCham);
        btnBang = findViewById(R.id.btnBang);*/

        for (int i = 0; i < dsIDButton.length; ++i)
        {
            button = findViewById(dsIDButton[i]);
            button.setOnClickListener(suKienAnNut);
        }
/*        dsButton = new Button[dsIDButton.length];
        for (int i = 0; i < dsButton.length; ++i)
        {
            dsButton[i] = findViewById(dsIDButton[i]);
            dsButton[i].setOnClickListener(suKienAnNut);
        }*/
/*        for(int id : dsIDButton)
        {
            view = findViewById(id);
            view.setOnClickListener(suKienAnNut);
        }*/
    }
    public void addEvents()
    {
        suKienAnNut = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.btnCong :
                        soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                        edtDuLieu.setText(((Button)v).getText().toString());
                        phepToan = "+";
                        break;
                    case R.id.btnTru:
                        soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                        edtDuLieu.setText(((Button)v).getText().toString());
                        phepToan = "-";
                        break;
                    case R.id.btnNhan :
                        soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                        edtDuLieu.setText(((Button)v).getText().toString());
                        phepToan = "x";
                        break;
                    case R.id.btnChia:
                        soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                        edtDuLieu.setText(((Button)v).getText().toString());
                        phepToan = "/";
                        break;
                    case R.id.btnDelete:
                        if(edtDuLieu.getText().length() != 0)
                        {
                            edtDuLieu.getText().delete(edtDuLieu.getText().length() - 1, edtDuLieu.getText().length());
                            //edtDuLieu.getText().replace(edtDuLieu.getText().length() - 1, edtDuLieu.getText().length(), "");
                        }
                        break;
                    case R.id.btnBang:
                        if(phepToan.equals("+"))
                        {
                            //edtDuLieu.setText();
                            //soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                            soThuHai = Double.parseDouble(edtDuLieu.getText().toString());
                            ketQua = soThuNhat + soThuHai;
                            edtDuLieu.setText(String.valueOf(ketQua));
                        }
                        else if(phepToan.equals("-"))
                        {
                            //soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                            soThuHai = Double.parseDouble(edtDuLieu.getText().toString());
                            ketQua = soThuNhat - soThuHai;
                            edtDuLieu.setText(String.valueOf(ketQua));
                        }
                        else if(phepToan.equals("x"))
                        {
                            //soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                            soThuHai = Double.parseDouble(edtDuLieu.getText().toString());
                            ketQua = soThuNhat * soThuHai;
                            edtDuLieu.setText(String.valueOf(ketQua));
                        }
                        else if(phepToan.equals("/"))
                        {
                            //soThuNhat = Double.parseDouble(edtDuLieu.getText().toString());
                            try
                            {
                                soThuHai = Double.parseDouble(edtDuLieu.getText().toString());
                                ketQua = soThuNhat / soThuHai;
                                edtDuLieu.setText(String.valueOf(ketQua));
                            }
                            catch (Exception ex)
                            {
                                ex.printStackTrace();
                            }
                        }
                        //edtDuLieu.append(((Button)v).getText().toString());
                        break;
                    default:
                        if((edtDuLieu.getText().toString().equals("0")) || edtDuLieu.getText().toString().equals("+")
                            || edtDuLieu.getText().toString().equals("-") || edtDuLieu.getText().toString().equals("x")
                            || edtDuLieu.getText().toString().equals("/"))
                        {
                            edtDuLieu.setText(((Button)v).getText().toString());
                        }
                        else
                        {
                            edtDuLieu.append(((Button)v).getText().toString());
                        }
                        //edtDuLieu.append(((Button)v).getText().toString());
                        break;
                }
            }
        };

    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addEvents();
        addControls();
    }

    @Override
    public void onClick(View v)
    {
        edtDuLieu.setText(((Button)v).getText().toString());
        Toast.makeText(MainActivity.this, ((Button)v).getText().toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this, "Nhấn thành công", Toast.LENGTH_LONG).show();
    }
}
