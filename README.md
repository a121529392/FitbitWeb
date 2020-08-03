# FitbitWeb

![image](https://github.com/a121529392/FitbitWeb/blob/master/fitbitweb_image/ar.PNG)
圖 1 為我的畢業專題的系統架構圖  
此專題主要是利用 FITBIT 手環取得駕駛人員心率，睡眠，運動狀況，用取得的知料來分析駕駛是否有疲勞駕駛的風險。  
我做的部分主要為向 FITBIT SERVER 取得使用者生理資料，再將取得的 json 檔decode 進利用 gson 自己建的 module，再將所有資料送入建在 gcp(Google Cloud Platform)上面的 MySQL 資料庫(以上是用 java)   寫的)。
### Web
下面幾張圖是 web 端的主要技術呈現  
![image](https://github.com/a121529392/FitbitWeb/blob/master/fitbitweb_image/web.PNG)
此頁面以動態管理呈現的每 5 秒更新一次，利用 ajax 更新，中間以 jsp(利用jetty server)方式向後端的資料庫取資料。  
![image](https://github.com/a121529392/FitbitWeb/blob/master/fitbitweb_image/mes.PNG)
此部分是利用 firebase 與 app 端即時溝通。  
![image](https://github.com/a121529392/FitbitWeb/blob/master/fitbitweb_image/vis.PNG)
此部分也是利用 ajax 從後端撈資料後再用 canvasjs 畫出折線圖  
![image](https://github.com/a121529392/FitbitWeb/blob/master/fitbitweb_image/map.PNG)
GPS 部分也是利用 firebase 向 IOT 上的 GPS 模組取得最新最即時的位置
