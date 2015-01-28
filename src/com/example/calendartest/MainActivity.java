package com.example.calendartest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carender.R;

public class MainActivity extends Activity implements OnClickListener {

	private Button nextMonthButton = null;				//次の月へボタン
	private Button previousMonthButton = null;			//前の月へボタン
	private Button button1 = null;
	private TextView headerMonthText = null;			//年月表示テキストビュー

	private int currentYear = 0;						//現在表示中の年
	private int currentMonth = 0;						//現在表示中の月

	private int nowYear = 0;							//現在の年
	private int nowMonth = 0;							//現在の月
	private int nowDay = 0;								//現在の日
	private NfcAdapter mNfcAdapter;

	//日表示テキスト情報リスト
	private ArrayList<DayTextViewInfo> dayTextList = new ArrayList<DayTextViewInfo>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(com.example.calendartest.MainActivity.this, com.example.database.DatabaseActivity.class);
				startActivity(intent);
			}
		});
		initializeControl();
		SetCalendar(0);

		//NFCを扱うためのインスタンスを取得します。
		mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
	}
	  public boolean onCreateOptionsMenu1(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }



	private void initializeControl(){

			this.nextMonthButton = (Button)findViewById(R.id.next_month_id);
			this.nextMonthButton.setOnClickListener(this);
			this.previousMonthButton = (Button)findViewById(R.id.previous_month_button);
			this.previousMonthButton.setOnClickListener(this);

			this.headerMonthText = (TextView)findViewById(R.id.header_month_text);

			DayTextViewInfo info = null;

			info = new DayTextViewInfo(R.id.one_su_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.one_mo_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.one_tu_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.one_we_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.one_th_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.one_fr_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.one_sa_text);
			this.dayTextList.add(info);

			info = new DayTextViewInfo(R.id.tow_su_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.tow_mo_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.tow_tu_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.tow_we_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.tow_th_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.tow_fr_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.tow_sa_text);
			this.dayTextList.add(info);

			info = new DayTextViewInfo(R.id.three_su_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.three_mo_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.three_tu_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.three_we_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.three_th_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.three_fr_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.three_sa_text);
			this.dayTextList.add(info);

			info = new DayTextViewInfo(R.id.four_su_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.four_mo_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.four_tu_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.four_we_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.four_th_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.four_fr_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.four_sa_text);
			this.dayTextList.add(info);

			info = new DayTextViewInfo(R.id.five_su_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.five_mo_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.five_tu_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.five_we_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.five_th_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.five_fr_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.five_sa_text);
			this.dayTextList.add(info);

			info = new DayTextViewInfo(R.id.six_su_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.six_mo_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.six_tu_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.six_we_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.six_th_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.six_fr_text);
			this.dayTextList.add(info);
			info = new DayTextViewInfo(R.id.six_sa_text);
			this.dayTextList.add(info);


		    Calendar cal1 = Calendar.getInstance();  			//(1)オブジェクトの生成

		    this.currentYear = cal1.get(Calendar.YEAR);        //(2)現在の年を取得
		    this.currentMonth = cal1.get(Calendar.MONTH) + 1;  //(3)現在の月を取得

		    this.nowYear = this.currentYear;
		    this.nowMonth = this.currentMonth;
		    this.nowDay = cal1.get(Calendar.DATE);         		//(4)現在の日を取得

		    int id = 0;
			for(int i = 0; i < 6; i++) {

				for(int j = 0; j < 7 ; j++){

					TextView tv = (TextView)findViewById(this.dayTextList.get(id).getTextViewId());
					tv.setOnClickListener(this);
					tv.setBackgroundResource(R.drawable.text_day_line);
					if(j == 0) {
						//日曜日
						tv.setTextColor(Color.RED);
					}
					if(j == 6) {
						//土曜日
						tv.setTextColor(Color.BLUE);
					}
					this.dayTextList.get(id).setTextObject(tv);
					id++;
				}
			}

			this.SetCalendar(0);
		}

		/**
		 * カレンダー再描画
		 */
		private void SetCalendar(int offset) {
			this.currentMonth += offset;

			if(currentMonth > 12){
				this.currentYear += 1;
				this.currentMonth = 1;
			}
			else if(currentMonth == 0){
				this.currentMonth = 12;
				this.currentYear -= 1;
			}

			//テキスト表示情報初期化
			for(int i = 0 ; i < this.dayTextList.size(); i++) {
				DayTextViewInfo tg = this.dayTextList.get(i);
				if(tg.isNowDay() || tg.isSelected() ) {
					tg.getTextObject().setBackgroundResource(R.drawable.text_day_line);
				}

				tg.setNowDay(false);
				tg.setDayNum(0);
				tg.setSelected(false);
				tg.getTextObject().setText(tg.getDispString());
			}

			//カレンダーテーブル作成
			CalendarInfo cl = new CalendarInfo(currentYear, currentMonth);

			int row = 0;
			int col = 0;
			for(int i = 0 ; i < this.dayTextList.size(); i++) {
				DayTextViewInfo tg = this.dayTextList.get(i);

				if(cl.calendarMatrix[row][col] != 0) {
					// 日付表示
					tg.setDayNum(cl.calendarMatrix[row][col]);
					tg.getTextObject().setText(tg.getDispString());
					if(this.nowYear == this.currentYear
						&& this.nowMonth == this.currentMonth
						&& cl.calendarMatrix[row][col] == nowDay) {

						// 当日日付表示
						this.dayTextList.get(i).setNowDay(true);
						tg.getTextObject().setBackgroundResource(R.drawable.text_selected_line);
					}
				}

				col += 1;
				if(col == 7){
					row += 1;
					col = 0;
				}
			}

			//年月表示
			this.headerMonthText.setText(String.valueOf(this.currentYear)
					+ "年" + String.valueOf(this.currentMonth) + "月" );
		}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	protected void onPause(){
		super.onPause();

		//Activityがバックグランドに回った際は、優先的に受け取る情報を停止します。
		//mNfcAdapter.disableForegroundDispatch(this);
	}

	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		byte[] uid = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);


		//NFC-UIDを、文字列に変換して表示します。
		Toast.makeText(this, Arrays.toString(uid), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自動生成されたメソッド・スタブ
		if(arg0.getId() == R.id.next_month_id) {
			this.SetCalendar(+1);
		}

		else if(arg0.getId() == R.id.previous_month_button) {
			this.SetCalendar(-1);

		}
		else
		{
			for(int i = 0 ; i < this.dayTextList.size(); i++) {
				if(this.dayTextList.get(i).getTextViewId() == arg0.getId()) {
					this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_selected_line);
					this.dayTextList.get(i).setSelected(true);
				}
				else {
					if(this.dayTextList.get(i).isNowDay() == true) {
						this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_now_line);
						this.dayTextList.get(i).setSelected(false);
					}
					else if(this.dayTextList.get(i).isSelected()) {
						this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_day_line);
						this.dayTextList.get(i).setSelected(false);
					}
				}
			}
		}

	}

}
