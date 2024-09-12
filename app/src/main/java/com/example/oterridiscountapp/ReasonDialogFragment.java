package com.example.oterridiscountapp;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;


import java.util.ArrayList;
import java.util.Objects;

public class ReasonDialogFragment extends DialogFragment {

    TextView btnCancel;
    TextView btnConfirm;
    TextView tvTitle;
    TextView tvDialogInfo;
    EditText etReason;
    Spinner spinnerPercentage;
    String strTitleText, strdialogInfo, strdialogCancelText, strapproveText;
    String selectedPercentage;
    ReasonClick reasonClick;
    private boolean hideCancelBtn = true, hideApproveBtn = true, showTitleText;
    ArrayList<String> reasonStringArrayList = new ArrayList<>();

    public void setUpInterface(ReasonClick reasonClick) {
        this.reasonClick = reasonClick;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyleTrans);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Objects.requireNonNull(dialog.getWindow()).setGravity(Gravity.CENTER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reason_dialog, container, false);
        btnConfirm = view.findViewById(R.id.btnConfirm);
        btnCancel = view.findViewById(R.id.btnCancel);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvDialogInfo = view.findViewById(R.id.tvDialogInfo);
        spinnerPercentage = view.findViewById(R.id.spinnerPercentage);
//        etReason = view.findViewById(R.id.etReason);

        setTitleText(strTitleText);
        setDialogInfo(strdialogInfo);
        setDialogCancelText(strdialogCancelText);
        setDialogApproveText(strapproveText);

//        Tools.setRequiredColor(strdialogInfo + "*", tvDialogInfo);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reasonClick.cancelClick();
                dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedPercentage.equalsIgnoreCase("Select percentage")){
                    Toast.makeText(requireContext(), "Please select percentage", Toast.LENGTH_SHORT).show();

                }else {

                    reasonClick.confirmClick(selectedPercentage);
                }



              /*  String reasonData = etReason.getText().toString().trim();

                try {
                    int reasonValue = Integer.parseInt(reasonData);
                    if (reasonValue > 40) {
                        etReason.setError("Discount cannot be less  than 1 and more than 40");
                        etReason.requestFocus();
                    } else {
                        reasonClick.confirmClick(reasonData);
                    }
                } catch (NumberFormatException e) {
                    etReason.setError("Please enter a valid number");
                    etReason.requestFocus();
                }*/
            }
        });

        reasonStringArrayList.add("Select percentage");
        reasonStringArrayList.add("9%");
        reasonStringArrayList.add("18%");

        ArrayAdapter ad = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, reasonStringArrayList);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPercentage.setAdapter(ad);
        spinnerPercentage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = String.valueOf(parent.getSelectedItem());
                selectedPercentage = selectedItem.replace("%", "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }


    public void setTitleText(String text) {
        strTitleText = text;
        if (tvTitle != null && strTitleText != null) {
            showTitleText();
            tvTitle.setText(HtmlCompat.fromHtml(strTitleText, HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }

    public void setDialogInfo(String dialogInfo) {
        strdialogInfo = dialogInfo;
        if (tvDialogInfo != null && dialogInfo != null) {
            tvDialogInfo.setVisibility(View.VISIBLE);
            tvDialogInfo.setText(HtmlCompat.fromHtml(strdialogInfo, HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }

    public void setDialogCancelText(String dialogCancelText) {
        strdialogCancelText = dialogCancelText;
        if (btnCancel != null && dialogCancelText != null) {
            btnCancel.setVisibility(View.VISIBLE);
            btnCancel.setText(strdialogCancelText);
        }
    }

    public void setDialogApproveText(String approveText) {
        strapproveText = approveText;
        if (btnConfirm != null && approveText != null) {
            btnConfirm.setVisibility(View.VISIBLE);
            btnConfirm.setText(strapproveText);
        }
    }

    public void hideCancelBtn(boolean hideCancel) {
        hideCancelBtn = hideCancel;
        if (hideCancelBtn) {
            btnCancel.setVisibility(View.GONE);
        } else {
            btnCancel.setVisibility(View.VISIBLE);
        }
    }

    public void setHideApproveBtn(boolean hideApprove) {
        hideApproveBtn = hideApprove;
        if (hideApproveBtn) {
            btnConfirm.setVisibility(View.GONE);
        }
    }

    private void showTitleText() {
        showTitleText = true;
        if (tvTitle != null) {
            tvTitle.setVisibility(View.VISIBLE);
        }
    }

    public interface ReasonClick {
        void confirmClick(String data);

        void cancelClick();
    }
}