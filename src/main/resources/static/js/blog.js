function eraseValue(){
    document.getElementById("content").value ="";
}
function eraseValueNick(){
  document.getElementById("nickname").value ="";
}

//일촌평 수정 시 수정창 구현
window.addEventListener("DOMContentLoaded",() => {
  function update(){
    const update = document.querySelectorAll(".updatecomment");
    const updatebutton = document.querySelectorAll(".updatebutton");
    for (let j = 0; j < update.length; j++) {
      updatebutton[j].addEventListener("click",() => {
          if (update[j].parentNode.childNodes[3].style.display === "none") {
            update[j].parentNode.childNodes[3].style.display = "block";
            update[j].parentNode.childNodes[1].style.display = "none";
          } else {
            update[j].parentNode.childNodes[3].style.display = "none";
            update[j].parentNode.childNodes[1].style.display = "block";
          }
      })
    }
  }
  update();
//방명록 수정 시 수정창 구현
  function updateguestpost(){
    const updateform = document.querySelectorAll(".guestbookupdateform");
    const guestupdatebutton = document.querySelectorAll(".guestupdatebutton");
    for (let k = 0; k < guestupdatebutton.length ; k++) {
      guestupdatebutton[k].addEventListener("click",() => {
          if(updateform[k].parentNode.childNodes[5].style.display==="block") {
            updateform[k].parentNode.childNodes[5].style.display = "none";
            updateform[k].parentNode.childNodes[3].style.display = "block";
          } else{
            updateform[k].parentNode.childNodes[5].style.display = "block";
            updateform[k].parentNode.childNodes[3].style.display = "none";
          }
          console.log(updateform[k].parentNode.childNodes[3])
      })
    }
    
  }
updateguestpost();

})

//방명록버튼 => 페이지 나오게 구현
const homepagebutton = document.querySelector('#homepage');
const writepagebutton = document.querySelector('#writepage');
const home = document.querySelector('.home');
const homesecond = document.querySelector('.homesecond');
writepagebutton.addEventListener('click',()=>{
  writepagebutton.style.color ="black";
  writepagebutton.style.backgroundColor ="white";
  writepagebutton.style.zIndex = 2;
  writepagebutton.style.borderLeft = 0;

  homepagebutton.style.color = "white"
  homepagebutton.style.backgroundColor ="#089DC8";
  homepagebutton.style.zIndex = 1;
  homepagebutton.style.borderLeft = "1px solid gray";

  home.style.display = "none";
  homesecond.style.display = "flex";
});
homepagebutton.addEventListener('click', ()=>{
  writepagebutton.style.color ="white";
  writepagebutton.style.backgroundColor ="#089DC8";
  writepagebutton.style.zIndex = 1;
  writepagebutton.style.borderLeft = "1px solid gray";

  homepagebutton.style.color ="black";
  homepagebutton.style.backgroundColor ="white";
  homepagebutton.style.zIndex = 2;
  homepagebutton.style.borderLeft = 0;

  home.style.display = "flex";
  homesecond.style.display = "none";
})


