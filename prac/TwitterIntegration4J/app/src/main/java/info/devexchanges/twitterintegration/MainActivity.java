package info.devexchanges.twitterintegration;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class MainActivity extends Activity {

    @InjectView(R.id.user_avatar)
    ImageView avatar;
    @InjectView(R.id.user_id)
    TextView userId;
    @InjectView(R.id.user_name)
    TextView userName;
    @InjectView(R.id.btn_login_tw)
    View btnLoginTwitter;
    @InjectView(R.id.data_layout)
    ViewGroup dataLayout;

    @OnClick(R.id.btn_logout)
    void onLogoutClick() {
        logout();
    }

    @OnClick(R.id.btn_login_tw)
    void onLoginClick() {
        if (isConnectingToInternet()) {
            new GetTwitterTokenTask(this).execute();
            Log.i("Activity", "login");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    public void callBackDataFromAsyncTask(User user) {
        userId.setText(String.valueOf(user.getId()));
        userName.setText(user.getName());
        dataLayout.setVisibility(View.VISIBLE);
        btnLoginTwitter.setVisibility(View.GONE);

        //loading User Avatar by Picasso
        Picasso.with(this)
                .load(user.getBiggerProfileImageURL())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(avatar);
    }

    private void logout() {
        Log.i("Activity", "logout");
        dataLayout.setVisibility(View.GONE);
        userId.setText("");
        userName.setText("");
        btnLoginTwitter.setVisibility(View.VISIBLE);
    }
}
