package com.immr.studentplanner.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.immr.studentplanner.model.Assessment;
import com.immr.studentplanner.R;

import java.util.ArrayList;

public class AssessmentAdapter extends ArrayAdapter<Assessment> {


    public AssessmentAdapter(@NonNull Context context, ArrayList<Assessment> assessment) {
        super(context, R.layout.assessment_row, assessment);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.assessment_row, parent, false);

        Assessment assessment = getItem(position);
        TextView assessmentName = customView.findViewById(R.id.assessTitleDet);

        assessmentName.setText(assessment.getTitle());

        return customView;
    }}
