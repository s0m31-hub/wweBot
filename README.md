# wweBot
First normal open-source project. Easy bot written in 2 days
This is my first normal open-source project i can publish. It's pretty easy and originally was used to send funny wrestlers pictures.  
To launch it, you need to have wwe.base in a same directory with jarfile.  
  
##wwe.base syntax  
Each result in query should be listed in wwe.base and should look like "keyword$http://link/to/a/photo.jpg"  
..*You can have up to 5 results under one keyword  
..*Keywords are not case-sensetive and ignores spaces with tabs  
Results are splitted with ";" and ignores any new lines/tabulations/spaces, so you can write them whatever you like  
..*There should be no seperator after last result  
###Example wwe.base file  
...  
funny face$https://effectlist.com/files/preview_image/4513458600589798.jpg;  
bot creator$https://tn.fishki.net/20/upload/post/2017/09/07/2375381/8d9392c4dd7a50fa37ae2ec96403c229.jpg;  
henry$https://www.ringsidenews.com/wp-content/uploads/2021/04/mark-henry-9494.jpg;  
henry$https://www.wwe.com/f/styles/gallery_img_l/public/photo/image/2013/04/SD_713_Photo_085.jpg  
...  
  
###this is how it will look like:  
![alt text](https://github.com/s0m31-hub/wweBot/blob/main/demos/DEMOcreator.jpg "bot creator")  
![alt text](https://github.com/s0m31-hub/wweBot/blob/main/demos/DEMOface.jpg "funny face")  
![alt text](https://github.com/s0m31-hub/wweBot/blob/main/demos/DEMOhenry.jpg "henry")  
  
##I am publishing this more for myself than for someone, but you can use this code if you are going to write Telegram bots   on Java and have no idea where to start
