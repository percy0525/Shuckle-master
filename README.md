![image](https://github.com/percy0525/Shuckle-master/blob/master/ReadPIC/shuckle3.gif)
# Shuckle
## Background
Once upon a time, there was a pokemon named Shuckle. He believed that he was born to be a super star, and was dreaming of the day he would become an outstanding singer. 

One lovely morning in the forest, Shuckle met Bellsprout, a famous vocal with several Golden Melody Awards. It was absolutely a great opportunity for him to make his dream come true.

"The distance between dreams and reality is called discipline."


## Description
Bellsprout taught Shuckle 3 methods to improve his singing skills. 

"Practice makes perfect." 

By keep reviewing these tips, Shuckle will surely realize his dream.


![image](https://github.com/percy0525/Shuckle-master/blob/master/ReadPIC/Main.png)


### First -> Pitch
Pitch is a perceptual property of sounds that allows their ordering on a frequency-related scale. 

![image](https://github.com/percy0525/Shuckle-master/blob/master/ReadPIC/Single0.png)

In the beginning, you will hear one single voice in an octave including half step and whole tone. 

Try your best to figure out the pitch of this voice as many times as possible!

### Second -> Rhythm
Rhythm generally means a movement marked by the regulated succession of strong and weak elements, or of opposite or different conditions.

![image](https://github.com/percy0525/Shuckle-master/blob/master/ReadPIC/Double2.png)

Listen to the rhythm carefully, and then repeat again by yourself!
There are different difficulties. Open your ears and be patient.

### Third -> Melody
Now it's time to see what you've got!

![image](https://github.com/percy0525/Shuckle-master/blob/master/ReadPIC/Triple2.png)


## Skills and Technologies
### mediaplayer
可播放音訊檔，所以將七大音階
player. create (this,R.raw.do);//創建音訊
player.start();  //播放剛才所創建的音訊
player.pause();  //暫停播放
player.stop();   //停止播放
player.release() //可以釋放播放器佔用的資源，若確定不用再播放最好是使用這個方法，才會不導致太多音訊同時播放而crash

### Thread
第二、三模式中，剛按鈕按下去後，另啟一個Thread來播放音樂，而主執行敘將button設定為setEnabled(false)，讓程式不會狂按按鈕而音樂重複播放而crash，另啟的Thread播放的音樂結束後，才重啟Button。

### Button setBackgroundResource
第三個模式中按下按鈕後(三首兒歌)，可更改image的背景色，提醒使用者此兒歌現在可進行播放或是挑戰模式。

### Ripple
七大音階按下去後的所產生的特效，讓使用者更明確的看出自己點的音符。

### ProgressBar
在第二模式中，使用者可明確知道自己按到第幾個音節。

### Image Manipulation
使用了小畫家3D來達成button image去背的功能。


## Contribution

![image](https://github.com/percy0525/Shuckle-master/blob/master/ReadPIC/shuckle4.gif)
