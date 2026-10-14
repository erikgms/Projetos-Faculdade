const tractor = document.getElementById('tractor');

let position = -130;
let direction = 1;

const desiredHeight = '455px';

tractor.style.height = desiredHeight;
tractor.style.position = 'absolute'

function animateTractor() {
    position += 5 * direction;

    tractor.style.left = position + 'px';

    if (position > window.innerWidth || position < -130){
            direction *= -1;

    if (direction === -1) {
        tractor.classList.add('flip');
    }else{
        tractor.classList.remove('flip');
    }
}
requestAnimationFrame(animateTractor); } animateTractor(); 