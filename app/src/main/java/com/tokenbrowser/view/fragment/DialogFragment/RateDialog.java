package com.tokenbrowser.view.fragment.DialogFragment;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.tokenbrowser.token.R;
import com.tokenbrowser.token.databinding.FragmentRateBinding;
import com.tokenbrowser.view.BaseApplication;

public class RateDialog extends DialogFragment {

    public static final String TAG = "RateDialog";
    public static final String USERNAME = "username";

    private FragmentRateBinding binding;
    private String username;
    private int rating;
    private String review;
    public OnRateDialogClickListener listener;

    public interface OnRateDialogClickListener {
        void onRateClicked(final int rating, final String review);
    }

    public void setOnRateDialogClickListener(final OnRateDialogClickListener listener) {
        this.listener = listener;
    }

    public static RateDialog newInstance(final String username) {
        final Bundle bundle = new Bundle();
        bundle.putString(USERNAME, username);
        final RateDialog fragment = new RateDialog();
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle state) {
        final Dialog dialog = super.onCreateDialog(state);
        if (dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rate, container, false);
        getBundleData();
        initView();
        initClickListeners();
        return this.binding.getRoot();
    }

    private void getBundleData() {
        this.username = this.getArguments().getString(USERNAME);
    }

    private void initView() {
        final String title = BaseApplication.get().getString(R.string.review_dialog_title, this.username);
        this.binding.title.setText(title);
    }

    private void initClickListeners() {
        this.binding.ratingView.setOnItemClickListener(rating -> this.rating = rating);
        this.binding.review.setOnClickListener(v -> {
            final String review = this.binding.reviewInput.getText().toString();
            this.listener.onRateClicked(this.rating, review);
            dismiss();
        });
        this.binding.noThanks.setOnClickListener(v -> dismiss());
    }
}
