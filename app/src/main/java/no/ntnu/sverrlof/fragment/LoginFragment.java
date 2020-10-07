package no.ntnu.sverrlof.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import no.ntnu.sverrlof.ApiClient;
import no.ntnu.sverrlof.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    EditText editTextUsername, editTextPwd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editTextUsername = view.findViewById(R.id.editTextUsernameOnLogin);
        editTextPwd = view.findViewById(R.id.editTextTextPassword);

        Button loginBtn = (Button) view.findViewById(R.id.loginbtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.loginbtn:
                        userLogin();
                        break;
                }
            }
        });
        return view;
    }

    private void userLogin() {
        String uid = editTextUsername.getText().toString().trim();
        String pwd = editTextPwd.getText().toString().trim();

        if (uid.isEmpty()) {
            editTextUsername.setError("Please enter a valid username");
            editTextUsername.requestFocus();
            return;
        }

        if (pwd.isEmpty()) {
            editTextPwd.setError("Please enter your password");
            editTextPwd.requestFocus();
            return;
        }

        Call<ResponseBody> call = ApiClient
                .getSINGLETON()
                .getApi()
                .userLogin(uid, pwd);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getActivity(), "Login successfull", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
