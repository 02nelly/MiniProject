let handleId = 0;   // 시계가 움직이는 동작
 const h1 = document.getElementById("time")
 const go = document.getElementById("btn_start")
 const stop = document.getElementById("btn_stop")

 // 현재 시간을 읽어오는 함수
 function getTime() {
    const date = new Date() 
    const hour = date.getHours();
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();
    const time = `${hour}:${minutes}:${seconds}`
    h1.textContent = time;
 }

 // go 버튼 클릭시
 go.onclick = function() {
    if(handleId == 0) {
        handleId = setInterval(getTime, 1000)
    }
 }

 // stop 버튼 클릭시
 stop.onclick = function() {
    clearInterval(handleId)
    handleId=0;
 }