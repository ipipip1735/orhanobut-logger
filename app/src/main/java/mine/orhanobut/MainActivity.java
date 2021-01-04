package mine.orhanobut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.DiskLogStrategy;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static android.os.Environment.DIRECTORY_PICTURES;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void start(View view) {
        System.out.println("~~start~~");

        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("hello");
        Logger.t("TNT");
        Logger.d("debug");
        Logger.t("TNT");
        Logger.e("error");
        Logger.w("warning");
        Logger.v("verbose");
        Logger.i("information");
        Logger.i("information", 1111);
        Logger.wtf("What a Terrible Failure");

    }

    public void stop(View view) {
        System.out.println("~~stop~~");

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 111);
        map.put("two", 222);
        map.put("three", 333);

        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d(map);


    }

    public void bind(View view) {
        System.out.println("~~bind~~");

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
//                .methodCount(2)         // (Optional) How many method line to show. Default 2
//                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("My custom tag")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

        Logger.t("TNT");
        Logger.d("hello");
        Logger.d("debug");
//        Logger.t("TNT");
//        Logger.e("error");
//        Logger.w("warning");
//        Logger.v("verbose");
//        Logger.i("information");
//        Logger.i("information", 1111);
//        Logger.wtf("What a Terrible Failure");
    }

    public void unbind(View view) {
        System.out.println("~~unbind~~");

        Logger.addLogAdapter(new DiskLogAdapter());//文件日志
        Logger.addLogAdapter(new AndroidLogAdapter());//控制台日志
        Logger.d("hello");
    }



}