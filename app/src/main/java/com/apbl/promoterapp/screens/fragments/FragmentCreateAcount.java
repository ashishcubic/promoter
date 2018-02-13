package com.apbl.promoterapp.screens.fragments;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.apbl.promoterapp.R;
import com.apbl.promoterapp.core.BaseActivity;
import com.apbl.promoterapp.core.BaseFragment;
import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.core.network.RestCallback;
import com.apbl.promoterapp.core.network.RestProcess;
import com.apbl.promoterapp.core.network.RetrofitAPIProvider;
import com.apbl.promoterapp.core.util.DialogUtil;
import com.apbl.promoterapp.core.util.Toaster;
import com.apbl.promoterapp.model.requestmodels.VerifyLAPUModel;
import com.apbl.promoterapp.model.responsemodels.VerifuLAPUResponse;
import com.apbl.promoterapp.network.APIService;
import com.apbl.promoterapp.network.ApiUtils;
import com.apbl.promoterapp.network.PromotorClient;
import com.apbl.promoterapp.screens.LoginContract;
import com.apbl.promoterapp.screens.viewmodels.LoginViewModel;
import com.apbl.promoterapp.util.Constants;
import com.apbl.promoterapp.util.LocalPreferences;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class FragmentCreateAcount extends BaseFragment implements View.OnClickListener {

    BaseLifecycle.ViewModel viewModel;
    private View mView;
    private String userType = "";
    EditText et_frag_login_lapu_num;
    //private LoginContract.ViewModel loginViewModel;
    private LocalPreferences localPreferences;
    private APIService mAPIService;
    private Context context;

    @Override
    protected BaseLifecycle.ViewModel getViewModel() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAPIService = ApiUtils.getAPIService();
        context = getActivity();
        localPreferences = new LocalPreferences(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_account, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        init();


    }

    private void init() {
        Spinner mSpinnerCategory = (Spinner) mView.findViewById(R.id.user_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.category_arrays, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        mSpinnerCategory.setAdapter(adapter);
        mSpinnerCategory.setOnItemSelectedListener(new Category());
        Button mLogin = (Button) mView.findViewById(R.id.btn_request_otp);
        mLogin.setOnClickListener(this);

        et_frag_login_lapu_num = (EditText) mView.findViewById(R.id.et_frag_login_lapu_num);


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_request_otp) {
            if (!userType.equals("")) {

                if (et_frag_login_lapu_num.getText().toString().trim().length() == 10) {

                    DialogUtil.showLoadingDialog(context);

                    localPreferences.saveSessionID(sessionId(userType));

                    sendPost(new VerifyLAPUModel("bhoopendra10091989@yahoo.com", "111", "1",
                            "1", "1", et_frag_login_lapu_num.getText().toString(), "1", "1", "1"));

                } else {
                    Toaster.shortToast(R.string.valid_lapu_no);

                }


            } else {
                Toaster.shortToast(R.string.empty_usertype);
            }
        }
    }


    public void sendPost(VerifyLAPUModel verifyLAPUModel) {
        mAPIService.verifyLAPUNew(verifyLAPUModel).enqueue(new Callback<VerifuLAPUResponse>() {
            @Override
            public void onResponse(Call<VerifuLAPUResponse> call, Response<VerifuLAPUResponse> response) {
                DialogUtil.dismissLoadingDialog();

                if (response.isSuccessful()) {

                    System.out.println("DATA--->" + response.body().getMessageText());

                    if (response.body().getCode().equals("0") && response.body().getFeSessionId() != null) {

                        Toaster.shortToast(response.body().getMessageText());

                        ((BaseActivity) getContext()).openFragment(new FragmentCreatePassword(), null,
                                Constants.Login.Title.LOGIN_MOBILE_NUM, R.id.frag_container);
                    } else {
                        Toaster.shortToast(response.body().getMessageText());

                    }


                } else {
                    Toaster.shortToast("LAPU number not verified");

                }
            }

            @Override
            public void onFailure(Call<VerifuLAPUResponse> call, Throwable t) {

                DialogUtil.dismissLoadingDialog();

                Toaster.shortToast("LAPU number not verified");


            }
        });
    }


    class Category implements OnItemSelectedListener {
        Category() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            switch (position) {
                case 0:
                    userType = "";
                    break;
                case 1:
                    userType = "Promoter";
                    break;
                case 2:
                    userType = "TL";
                    break;
                case 3:
                    userType = "RM";
                    break;
            }

        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public String getAppVersion() {

        try {
            PackageInfo pInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;

        }
    }

    public String sessionId(String user_type) {

        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        sb.append(user_type);

        for (int i = 0; i < 15; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public String getUniqueId() {
        return Settings.Secure.getString(getContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }
}
