package com.example.rainbowmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton_a1,imageButton_b2;  //设置触发菜单的按钮
    private RelativeLayout l2,l3;    //二级菜单和三级菜单
    private boolean isl2Show=true;  //判断二级菜单是否显示
    private boolean isl3Show=true;  //判断三级菜单是否显示


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取触发菜单的按钮
        imageButton_a1 =findViewById(R.id.a_1);   //获取用于触发二级菜单的按钮
        imageButton_b2 =findViewById(R.id.b_2);   //获取用于触发三级菜单的按钮
        //获取二级菜单与三级菜单的布局
        l2=findViewById(R.id.level_2);
        l3=findViewById(R.id.level_3);
        //单击该按钮显示或隐藏三级菜单
        imageButton_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isl3Show){
                    //隐藏三级导航菜单
                    MyAnimation.animationOUT(l3,500,0);
                }else{
                    //显示三级菜单
                    MyAnimation.animationIN(l3,500);
                }
                isl3Show=!isl3Show;  //修改三级菜单显示
            }
        });

        imageButton_a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isl2Show){
                    //显示二级菜单
                    MyAnimation.animationIN(l2,500);
                }else {
                    if(isl3Show){
                        //隐藏三级菜单
                        MyAnimation.animationOUT(l3,500,0);
                        //隐藏二级菜单
                        MyAnimation.animationOUT(l2,500,0);
                        isl3Show = !isl2Show;   //修改三级菜单显示状态为隐藏状态
                    }else{
                        //隐藏二级菜单
                        MyAnimation.animationOUT(l2,500,0);
                    }
                }
                isl2Show = !isl2Show;   //修改二级菜单显示
            }
        });

    }
}
