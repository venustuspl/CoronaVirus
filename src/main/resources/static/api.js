/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

const ad = document.getElementById('alldata');

fetch("/archivepolanddata?year=2020&month=03&day=14")
    .then((resp) => resp.json()) // Transform the data into json
       .then(function (data) {

           // Map through the results and for each run the code below
           let li = createNode('li'), //  Create the elements we need
               span = createNode('span');
           li.innerHTML = `${data.Poland}`; // Make the HTML of our span to be the first and last name of our author
           append(li, span);
           append(ad, li);

       });
