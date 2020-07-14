package ru.sap.testqr;

import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;

import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onResume() {
        super.onResume();

//        Intent intent = getIntent();
//        Uri uri = intent.getData();
//        if (uri != null) {
//            String param = uri.getQueryParameter("param");
//            Toast toast = Toast.makeText(getApplicationContext(), param, Toast.LENGTH_SHORT);
//            toast.show();(@NonNull CharSequence text,
//                @NonNull @CallbackExecutor Executor executor,
//                @NonNull DialogInterface.OnClickListener listener)
////        }
//
        BiometricPrompt prompt = new BiometricPrompt.Builder(getApplicationContext()).setDescription("description").setTitle("title").setSubtitle("subtitle").setNegativeButton("abcd", this.getMainExecutor(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do nothing
            }
        }).build();
        prompt.authenticate(new CancellationSignal(), this.getMainExecutor(), new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                super.onAuthenticationHelp(helpCode, helpString);
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        //new FingerprintManager().authenticate();
    }
}
