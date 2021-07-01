package com.example.listexample01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list; //변수명 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list); //activity에 list와 여기의 list를 연결

        List<String> data = new ArrayList<>();
        //List라는 자료형을 만들어줘야해 데이터를 넣기위해
        //List는 String 형식이다 이름은 data
        //ArrayList - 배열 안에 스트링 형태로 넣을것이다.

        //데이터 저장하는 list와 list view 를 연결해주는 역할이 어뎁터
        //흔히 콘센트 어뎁터라부른다

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        //this를 적으면 현재 엑티비티에 해당된다. 라는뜻 기본재공하는  UI를 사용하는것 and~~~.simple은 그냥 아무거나 추천나온거
        //마지막에 선언한 data를 뒤에 해줌
        list.setAdapter(adapter);
        //list view에다가 다리역할을하는 adapter를 세팅해줘야함 그래서 setAdapter
        //adapter라는 이름으로 설정한 친구를 세팅해준것
        data.add("명석최고");//data add(String) data라는 곳에 String 데이터를 추가해준다.
        data.add("열공합시다");
        adapter.notifyDataSetChanged();//상태저장완료 하는 의미

    }
}