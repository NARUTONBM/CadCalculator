package com.naruto.cadcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private EditText mEt_start_x;
	private EditText mEt_start_y;
	private EditText mEt_target_x;
	private EditText mEt_target_y;
	private EditText mEt_per_distance;
	private EditText mEt_height_increase;
	private TextView mTv_height_result;
	private TextView mTv_radius_result;
	private RadioButton mRb_sector_area;
	private RadioButton mRb_block_area;
	private RadioGroup mRg_area_select;
	private EditText mEt_start_z;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUI();
	}

	private void initUI() {

		mRg_area_select = (RadioGroup) findViewById(R.id.rg_area_select);
		mRb_block_area = (RadioButton) findViewById(R.id.rb_block_area);
		mRb_sector_area = (RadioButton) findViewById(R.id.rb_sector_area);
		mEt_start_x = (EditText) findViewById(R.id.et_start_x);
		mEt_start_y = (EditText) findViewById(R.id.et_start_y);
		mEt_start_z = (EditText) findViewById(R.id.et_start_z);
		mEt_target_y = (EditText) findViewById(R.id.et_target_y);
		mEt_target_x = (EditText) findViewById(R.id.et_target_x);
		mEt_per_distance = (EditText) findViewById(R.id.et_per_distance);
		mEt_height_increase = (EditText) findViewById(R.id.et_height_increase);
		Button bt_calculte = (Button) findViewById(R.id.bt_calculte);
		mTv_height_result = (TextView) findViewById(R.id.tv_height_result);
		mTv_radius_result = (TextView) findViewById(R.id.tv_radius_result);
		bt_calculte.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		double startX = Double.parseDouble(mEt_start_x.getText().toString());
		double startY = Double.parseDouble(mEt_start_y.getText().toString());
		double startZ = Double.parseDouble(mEt_start_z.getText().toString());
		double targetX = Double.parseDouble(mEt_target_x.getText().toString());
		double targetY = Double.parseDouble(mEt_target_y.getText().toString());
		double perDistance = Double.parseDouble(mEt_per_distance.getText().toString());
		double heightIncrease = Double.parseDouble(mEt_height_increase.getText().toString());
		double height = 0;
		double radiu = 0;

		switch (mRg_area_select.getCheckedRadioButtonId()) {

		case R.id.rb_block_area:

			height = Math.sqrt((targetX - startX) * (targetX - startX) + (targetY - startY) * (targetY - startY)) / perDistance * 1000
							* heightIncrease + startZ;

			break;

		case R.id.rb_sector_area:

			radiu = Math.sqrt((targetX - startX) * (targetX - startX) + (targetY - startY) * (targetY - startY));
			height = radiu / perDistance * 1000 * heightIncrease + startZ;

			break;

		default:
			break;
		}

		mTv_height_result.setText("高度：" + height + "m");
		mTv_radius_result.setText("半径：" + radiu + "km");
	}
}
