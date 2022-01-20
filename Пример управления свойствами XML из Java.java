// получение размера экрана в пикселях
Display display = getWindowManager().getDefaultDisplay();
Point size = new Point();
display.getSize(size);
int btnHeight = size.y / 2;
int btnWidth = size.x / 2;

Button btn = findViewById(R.id.btn);
TextView txt = findViewById(R.id.time);

// установка свойств для кнопки
FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, btnHeight);
layoutParams.gravity = Gravity.BOTTOM;
layoutParams.leftMargin = 15;
layoutParams.rightMargin = 15;
btn.setText("Start");
btn.setLayoutParams(layoutParams);

// установка свойств для текста
FrameLayout.LayoutParams txtParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, btnHeight - 215);
txt.setBackgroundColor(Color.BLUE);
txt.setLayoutParams(txtParams);
txt.setGravity(Gravity.CENTER);
txt.setText("00:00:00");
txt.setTextSize(60)
