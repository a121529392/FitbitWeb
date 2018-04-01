var parts = ['#logo', '#about', '#sign', '#contact'];

$(() => {
  $('#menu > ul > li').on('click', (event) => {
    $('html, body').animate({
      scrollTop: $(event.target.getAttribute('value')).offset().top
    }, 'normal');
    event.preventDefault();
  });
  parts = _(parts).map(div => Object({name: div, Y_axis: $(div).offset().top})).value();
  $(window).scroll((event) => {
    for (let i = 0; i < parts.length; ++i) {
      if (window.pageYOffset >= parts[i].Y_axis && !$(parts[i].name).hasClass('hover')) $(parts[i].name).addClass('hover');
    }
  });
});