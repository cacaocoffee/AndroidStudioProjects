package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        //글자를 입력하고 앱을 뒤로가기버튼을 눌러 종료를 했을때
        String value = sharedPreferences.getString("king","");
        //밑에서 지정한 이름 인 "king" 그리고 꺼내오는 것이기 때문에 defValue에는 아무것도 입력하지 않음
        et_save.setText(value);
        //value를 setText해줘라 value에 있는 String 값을 저장 어디에?-EditText 앱 실행하면 입력 받는 곳

    }
    //ctrl + O    ondestroy 더블클릭 하면 ondestroy라는 생명주기가 하나 더생겨
    //앱을 종료시켰을때 -정확히는 이 액티비티를 벗어났을때 액티비티가 파괴되는

    //앱이 취소되었을때 나갔을때 sharedpreferences에 저장시켜 놓을 수 있게 다시 불러오기위함
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //sharedPreferences.edit을 연결해준것
        // Editor 저장할때 항상 editor가 필요함
        String value = et_save.getText().toString();
        //EditText에 현재 써져있는 값을 받아오는 부분이 EditText.getText() 그걸 String 형태로 빼겠다
        //해서 뒤에 toString();
        editor.putString("king",value);//editor에 스트링을 저장하기 위한것 아무거나
        //king이라는 이름으로 value를 저장할거야.
        editor.commit();//이게 실질적인 저장을 완료해라 라는 의미
    }
}