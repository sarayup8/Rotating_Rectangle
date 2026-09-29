package com.example.in_classactivity5;

import android.graphics.PointF;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MyDrawView myDrawView;
    Button rotateButton;
    Button drawButton;

    EditText Ax, Ay;
    EditText Bx, By;
    EditText Cx, Cy;
    EditText Dx, Dy;

    float centerX;
    float centerY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ax = findViewById(R.id.Ax);
        Ay = findViewById(R.id.Ay);

        Bx = findViewById(R.id.Bx);
        By = findViewById(R.id.By);

        Cx = findViewById(R.id.Cx);
        Cy = findViewById(R.id.Cy);

        Dx = findViewById(R.id.Dx);
        Dy = findViewById(R.id.Dy);

        myDrawView = findViewById(R.id.myDrawView);

        rotateButton = findViewById(R.id.rotateButton);
        drawButton = findViewById(R.id.drawButton);

        drawButton.setOnClickListener(v -> {
            try {

                float ax = Float.parseFloat(Ax.getText().toString());
                float ay = Float.parseFloat(Ay.getText().toString());

                float bx = Float.parseFloat(Bx.getText().toString());
                float by = Float.parseFloat(By.getText().toString());

                float cx = Float.parseFloat(Cx.getText().toString());
                float cy = Float.parseFloat(Cy.getText().toString());

                float dx = Float.parseFloat(Dx.getText().toString());
                float dy = Float.parseFloat(Dy.getText().toString());

                // Check that all coordinates are between 0 and 300
                if (!validateCoordinate(ax) || !validateCoordinate(ay) || !validateCoordinate(bx) || !validateCoordinate(by) || !validateCoordinate(cx) || !validateCoordinate(cy) || !validateCoordinate(dx) || !validateCoordinate(dy)) {
                    Toast.makeText(this, "All coordinates must be between 0 and 300", Toast.LENGTH_SHORT).show();
                } else {

                    // Create 4 vertices
                    PointF A = new PointF(ax, ay);
                    PointF B = new PointF(bx, by);
                    PointF C = new PointF(cx, cy);
                    PointF D = new PointF(dx, dy);

                    myDrawView.setPoints(A, B, C, D);

                    centerX = (A.x + B.x + C.x + D.x) / 4;
                    centerY = (A.y + B.y + C.y + D.y) / 4;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Enter all coordinates", Toast.LENGTH_SHORT).show();
            }
        });

        rotateButton.setOnClickListener(v ->  myDrawView.rotate(10, centerX, centerY));
        }
        private boolean validateCoordinate(float value){
            return value >= 0 && value <= 300;
    }
}