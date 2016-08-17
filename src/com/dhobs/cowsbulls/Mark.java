package com.dhobs.cowsbulls;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class Mark extends Activity implements OnClickListener {
	private String[] alpha = { "_", "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
			"V", "W", "X", "Y", "Z" };
	Button b1, b2, b3, b4, b5;
	private int y1, y2, y3, y4, y5;
	int b;
	private Intent in;
	Button A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, r, S, T, U, V, X,
			W, Z, Y;
	int[] val = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0 };
	static Tracker t;
	boolean bt,bt2;

	@Override
	protected void onStart() {
		super.onStart();
		GoogleAnalytics.getInstance(this).reportActivityStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		GoogleAnalytics.getInstance(this).reportActivityStop(this);
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mark);
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		loadP();
		A = (Button) findViewById(R.id.A);
		B = (Button) findViewById(R.id.B);
		C = (Button) findViewById(R.id.C);
		D = (Button) findViewById(R.id.D);
		E = (Button) findViewById(R.id.E);
		F = (Button) findViewById(R.id.F);
		G = (Button) findViewById(R.id.G);
		H = (Button) findViewById(R.id.H);
		I = (Button) findViewById(R.id.I);
		J = (Button) findViewById(R.id.J);
		K = (Button) findViewById(R.id.K);
		L = (Button) findViewById(R.id.L);
		M = (Button) findViewById(R.id.M);
		N = (Button) findViewById(R.id.N);
		O = (Button) findViewById(R.id.O);
		P = (Button) findViewById(R.id.P);
		Q = (Button) findViewById(R.id.Q);
		r = (Button) findViewById(R.id.R);
		S = (Button) findViewById(R.id.S);
		T = (Button) findViewById(R.id.T);
		U = (Button) findViewById(R.id.U);
		V = (Button) findViewById(R.id.V);
		W = (Button) findViewById(R.id.W);
		X = (Button) findViewById(R.id.X);
		Y = (Button) findViewById(R.id.Y);
		Z = (Button) findViewById(R.id.Z);
		in = getIntent();
		int n = in.getExtras().getInt("no");
		y1 = in.getExtras().getInt("y1");
		y2 = in.getExtras().getInt("y2");
		y3 = in.getExtras().getInt("y3");
		y4 = in.getExtras().getInt("y4");
		y5 = in.getExtras().getInt("y5");
		val = in.getExtras().getIntArray("val");
		bt = in.getExtras().getBoolean("bt");
		bt2 = in.getExtras().getBoolean("bt2");
		LinearLayout mmm = (LinearLayout) findViewById(R.id.mmm);
		if (b == 1)
			mmm.setBackgroundResource(R.drawable.wall);
		else
			mmm.setBackgroundResource(R.drawable.background_cross);
		if (val[0] == 1) {
			A.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[1] == 1) {
			B.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[2] == 1) {
			C.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[3] == 1) {
			D.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[4] == 1) {
			E.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[5] == 1) {
			F.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[6] == 1) {
			G.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[7] == 1) {
			H.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[8] == 1) {
			I.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[9] == 1) {
			J.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[10] == 1) {
			K.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[11] == 1) {
			L.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[12] == 1) {
			M.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[13] == 1) {
			N.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[14] == 1) {
			O.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[15] == 1) {
			P.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[16] == 1) {
			Q.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[17] == 1) {
			r.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[18] == 1) {
			S.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[19] == 1) {
			T.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[20] == 1) {
			W.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[21] == 1) {
			X.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[22] == 1) {
			Y.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[23] == 1) {
			Z.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[24] == 1) {
			U.setBackgroundResource(R.drawable.ic_action_remove);
		}
		if (val[25] == 1) {
			V.setBackgroundResource(R.drawable.ic_action_remove);
		}
		LinearLayout l = (LinearLayout) findViewById(R.id.l);
		switch (n) {
		case 5:
			final Button b5 = new Button(this);
			b5.setText(alpha[y5]);
			b5.setPadding(0, 0, 0, 0);
			l.addView(b5, new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			b5.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					AlertDialog.Builder alert = new AlertDialog.Builder(
							Mark.this);
					final NumberPicker np = new NumberPicker(Mark.this);
					np.setMinValue(0);
					np.setMaxValue(26);
					np.setDisplayedValues(alpha);
					np.setWrapSelectorWheel(false);
					np.setValue(y5);
					alert.setView(np);
					np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
						@Override
						public void onValueChange(NumberPicker picker,
								int oldVal, int newVal) {
							y5 = newVal;
						}
					});
					alert.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();
									np.setValue(y5);
									b5.setText(alpha[y5]);
								}
							});
					alert.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.cancel();
								}
							});
					alert.show();
				}
			});
		case 4:
			final Button b4 = new Button(this);
			b4.setText(alpha[y4]);
			b4.setPadding(0, 0, 0, 0);
			b4.setId(4);
			l.addView(b4, new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			b4.setOnClickListener(new View.OnClickListener() {

				public void onClick(final View v) {
					AlertDialog.Builder alert = new AlertDialog.Builder(
							Mark.this);
					final NumberPicker np = new NumberPicker(Mark.this);
					np.setMinValue(0);
					np.setMaxValue(26);
					np.setDisplayedValues(alpha);
					np.setWrapSelectorWheel(false);
					np.setValue(y4);
					alert.setView(np);
					np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
						@Override
						public void onValueChange(NumberPicker picker,
								int oldVal, int newVal) {
							y4 = newVal;
						}
					});
					alert.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();
									np.setValue(y4);
									b4.setText(alpha[y4]);
								}
							});
					alert.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.cancel();
								}
							});
					alert.show();
				}
			});
		case 3:
			final Button b3 = new Button(this);
			b3.setText(alpha[y3]);
			b3.setPadding(0, 0, 0, 0);
			l.addView(b3, new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			b3.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					AlertDialog.Builder alert = new AlertDialog.Builder(
							Mark.this);
					final NumberPicker np = new NumberPicker(Mark.this);
					np.setMinValue(0);
					np.setMaxValue(26);
					np.setDisplayedValues(alpha);
					np.setWrapSelectorWheel(false);
					np.setValue(y3);
					alert.setView(np);
					np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
						@Override
						public void onValueChange(NumberPicker picker,
								int oldVal, int newVal) {
							y3 = newVal;
						}
					});
					alert.setPositiveButton("Ok",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();
									b3.setText(alpha[y3]);
								}
							});
					alert.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.cancel();
								}
							});
					alert.show();
				}
			});
		case 2:
			final Button b2 = new Button(this);
			b2.setText(alpha[y2]);
			b2.setPadding(0, 0, 0, 0);
			l.addView(b2, new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			b2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					AlertDialog.Builder alert = new AlertDialog.Builder(
							Mark.this);
					final NumberPicker np = new NumberPicker(Mark.this);
					np.setMinValue(0);
					np.setMaxValue(26);
					np.setDisplayedValues(alpha);
					np.setWrapSelectorWheel(false);
					np.setValue(y2);
					alert.setView(np);
					np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
						@Override
						public void onValueChange(NumberPicker picker,
								int oldVal, int newVal) {
							y2 = newVal;
						}
					});
					alert.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();
									b2.setText(alpha[y2]);
								}
							});
					alert.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.cancel();
								}
							});
					alert.show();
				}
			});
		case 1:
			final Button b1 = new Button(this);
			b1.setText(alpha[y1]);
			b1.setPadding(0, 0, 0, 0);
			l.addView(b1, new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			b1.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					AlertDialog.Builder alert = new AlertDialog.Builder(
							Mark.this);
					final NumberPicker np = new NumberPicker(Mark.this);
					np.setMinValue(0);
					np.setMaxValue(26);
					np.setDisplayedValues(alpha);
					np.setWrapSelectorWheel(false);
					np.setValue(y1);
					alert.setView(np);
					np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
						@Override
						public void onValueChange(NumberPicker picker,
								int oldVal, int newVal) {
							y1 = newVal;
						}
					});
					alert.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.dismiss();
									b1.setText(alpha[y1]);
								}
							});
					alert.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int whichButton) {
									dialog.cancel();
								}
							});
					alert.show();
				}
			});
			break;
		default:
			break;
		}

		A.setText("A");
		B.setText("B");
		C.setText("C");
		D.setText("D");
		E.setText("E");
		F.setText("F");
		G.setText("G");
		H.setText("H");
		I.setText("I");
		J.setText("J");
		K.setText("K");
		L.setText("L");
		M.setText("M");
		N.setText("N");
		O.setText("O");
		P.setText("P");
		Q.setText("Q");
		r.setText("R");
		S.setText("S");
		T.setText("T");
		U.setText("U");
		V.setText("V");
		W.setText("W");
		X.setText("X");
		Y.setText("Y");
		Z.setText("Z");
		A.setOnClickListener(this);
		B.setOnClickListener(this);
		C.setOnClickListener(this);
		D.setOnClickListener(this);
		E.setOnClickListener(this);
		F.setOnClickListener(this);
		G.setOnClickListener(this);
		H.setOnClickListener(this);
		I.setOnClickListener(this);
		J.setOnClickListener(this);
		K.setOnClickListener(this);
		L.setOnClickListener(this);
		M.setOnClickListener(this);
		N.setOnClickListener(this);
		O.setOnClickListener(this);
		P.setOnClickListener(this);
		Q.setOnClickListener(this);
		r.setOnClickListener(this);
		S.setOnClickListener(this);
		T.setOnClickListener(this);
		U.setOnClickListener(this);
		V.setOnClickListener(this);
		W.setOnClickListener(this);
		X.setOnClickListener(this);
		Y.setOnClickListener(this);
		Z.setOnClickListener(this);
	}

	@Override
	public void onBackPressed() {
		Bundle bun = new Bundle();
		bun.putInt("y1", y1);
		bun.putInt("y2", y2);
		bun.putInt("y3", y3);
		bun.putInt("y4", y4);
		bun.putInt("y5", y5);
		bun.putIntArray("val", val);
		bun.putBoolean("bt", bt);
		bun.putBoolean("bt2", bt2);
		in.putExtras(bun);
		setResult(RESULT_OK, in);
		finish();
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.close, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.close:
			Bundle bun = new Bundle();
			bun.putInt("y1", y1);
			bun.putInt("y2", y2);
			bun.putInt("y3", y3);
			bun.putInt("y4", y4);
			bun.putInt("y5", y5);
			bun.putBoolean("bt", bt);
			bun.putBoolean("bt2", bt2);
			bun.putIntArray("val", val);
			in.putExtras(bun);
			setResult(RESULT_OK, in);
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);

		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.A:
			if (val[0] == 0) {
				A.setBackgroundResource(R.drawable.ic_action_remove);
				val[0] = 1;
			} else {
				A.setBackgroundResource(0);
				val[0] = 0;
			}
			break;
		case R.id.B:
			if (val[1] == 0) {
				B.setBackgroundResource(R.drawable.ic_action_remove);
				val[1] = 1;
			} else {
				B.setBackgroundResource(0);
				val[1] = 0;
			}
			break;
		case R.id.C:
			if (val[2] == 0) {
				C.setBackgroundResource(R.drawable.ic_action_remove);
				val[2] = 1;
			} else {
				C.setBackgroundResource(0);
				val[2] = 0;
			}
			break;
		case R.id.D:
			if (val[3] == 0) {
				D.setBackgroundResource(R.drawable.ic_action_remove);
				val[3] = 1;
			} else {
				D.setBackgroundResource(0);
				val[3] = 0;
			}
			break;
		case R.id.E:
			if (val[4] == 0) {
				E.setBackgroundResource(R.drawable.ic_action_remove);
				val[4] = 1;
			} else {
				E.setBackgroundResource(0);
				val[4] = 0;
			}
			break;
		case R.id.F:
			if (val[5] == 0) {
				F.setBackgroundResource(R.drawable.ic_action_remove);
				val[5] = 1;
			} else {
				F.setBackgroundResource(0);
				val[5] = 0;
			}
			break;
		case R.id.G:
			if (val[6] == 0) {
				G.setBackgroundResource(R.drawable.ic_action_remove);
				val[6] = 1;
			} else {
				G.setBackgroundResource(0);
				val[6] = 0;
			}
			break;
		case R.id.H:
			if (val[7] == 0) {
				H.setBackgroundResource(R.drawable.ic_action_remove);
				val[7] = 1;
			} else {
				H.setBackgroundResource(0);
				val[7] = 0;
			}
			break;
		case R.id.I:
			if (val[8] == 0) {
				I.setBackgroundResource(R.drawable.ic_action_remove);
				val[8] = 1;
			} else {
				I.setBackgroundResource(0);
				val[8] = 0;
			}
			break;
		case R.id.J:
			if (val[9] == 0) {
				J.setBackgroundResource(R.drawable.ic_action_remove);
				val[9] = 1;
			} else {
				J.setBackgroundResource(0);
				val[9] = 0;
			}
			break;
		case R.id.K:
			if (val[10] == 0) {
				K.setBackgroundResource(R.drawable.ic_action_remove);
				val[10] = 1;
			} else {
				K.setBackgroundResource(0);
				val[10] = 0;
			}
			break;
		case R.id.L:
			if (val[11] == 0) {
				L.setBackgroundResource(R.drawable.ic_action_remove);
				val[11] = 1;
			} else {
				L.setBackgroundResource(0);
				val[11] = 0;
			}
			break;
		case R.id.M:
			if (val[12] == 0) {
				M.setBackgroundResource(R.drawable.ic_action_remove);
				val[12] = 1;
			} else {
				M.setBackgroundResource(0);
				val[12] = 0;
			}
			break;
		case R.id.N:
			if (val[13] == 0) {
				N.setBackgroundResource(R.drawable.ic_action_remove);
				val[13] = 1;
			} else {
				N.setBackgroundResource(0);
				val[13] = 0;
			}
			break;
		case R.id.O:
			if (val[14] == 0) {
				O.setBackgroundResource(R.drawable.ic_action_remove);
				val[14] = 1;
			} else {
				O.setBackgroundResource(0);
				val[14] = 0;
			}
			break;
		case R.id.P:
			if (val[15] == 0) {
				P.setBackgroundResource(R.drawable.ic_action_remove);
				val[15] = 1;
			} else {
				P.setBackgroundResource(0);
				val[15] = 0;
			}
			break;
		case R.id.Q:
			if (val[16] == 0) {
				Q.setBackgroundResource(R.drawable.ic_action_remove);
				val[16] = 1;
			} else {
				Q.setBackgroundResource(0);
				val[16] = 0;
			}
			break;
		case R.id.R:
			if (val[17] == 0) {
				r.setBackgroundResource(R.drawable.ic_action_remove);
				val[17] = 1;
			} else {
				r.setBackgroundResource(0);
				val[17] = 0;
			}
			break;
		case R.id.S:
			if (val[18] == 0) {
				S.setBackgroundResource(R.drawable.ic_action_remove);
				val[18] = 1;
			} else {
				S.setBackgroundResource(0);
				val[18] = 0;
			}
			break;
		case R.id.T:
			if (val[19] == 0) {
				T.setBackgroundResource(R.drawable.ic_action_remove);
				val[19] = 1;
			} else {
				T.setBackgroundResource(0);
				val[19] = 0;
			}
			break;
		case R.id.W:
			if (val[20] == 0) {
				W.setBackgroundResource(R.drawable.ic_action_remove);
				val[20] = 1;
			} else {
				W.setBackgroundResource(0);
				val[20] = 0;
			}
			break;
		case R.id.X:
			if (val[21] == 0) {
				X.setBackgroundResource(R.drawable.ic_action_remove);
				val[21] = 1;
			} else {
				X.setBackgroundResource(0);
				val[21] = 0;
			}
			break;
		case R.id.Y:
			if (val[22] == 0) {
				Y.setBackgroundResource(R.drawable.ic_action_remove);
				val[22] = 1;
			} else {
				Y.setBackgroundResource(0);
				val[22] = 0;
			}
			break;
		case R.id.Z:
			if (val[23] == 0) {
				Z.setBackgroundResource(R.drawable.ic_action_remove);
				val[23] = 1;
			} else {
				Z.setBackgroundResource(0);
				val[23] = 0;
			}
			break;
		case R.id.U:
			if (val[24] == 0) {
				U.setBackgroundResource(R.drawable.ic_action_remove);
				val[24] = 1;
			} else {
				U.setBackgroundResource(0);
				val[24] = 0;
			}
			break;
		case R.id.V:
			if (val[25] == 0) {
				V.setBackgroundResource(R.drawable.ic_action_remove);
				val[25] = 1;
			} else {
				V.setBackgroundResource(0);
				val[25] = 0;
			}
			break;
		default:
			break;
		}

	}

	private void loadP() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		b = sp.getInt("b", 0);
	}

}
