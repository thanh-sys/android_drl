document.querySelectorAll('#part1 input, #part2 input, #part3 input, #part4 input, #part5 input').forEach(input => {
    input.disabled = true;
});
document.querySelector('#inputImage').disabled = false;
