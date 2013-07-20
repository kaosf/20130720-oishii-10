package com.example.oishii10;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				EditText column = (EditText) findViewById(R.id.editText1);
				String name = column.getText().toString();
				
				Log.d("oishii10", name);
				Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT)
						.show();
				// Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				// intent.putExtra("Name", name);
				// startActivity(intent);
				
				Intent intent = new Intent();
				intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, 207);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 207) {
			if (resultCode == RESULT_OK) {
				Bitmap bitmap = (Bitmap) data.getExtras().get("data");
				ImageView view = (ImageView) findViewById(R.id.imageView1);
				view.setImageBitmap(bitmap);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
