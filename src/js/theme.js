/**
 * MStore | Modern Bootstrap E-Commerce Template
 * Theme core scripts
 * 
 * @author Createx Studio
 * @version 1.0
 */

;(function ($) {
  'use strict';

  /**
   * Global variables
   * @const
  */
  var BODY = 'body';
  var WINDOW = window;
  var DOCUMENT = 'document';


  var theme = {

    /**
     * Theme's components/functions list
     * Comment out or delete the unnecessary component.
     * Some component have dependencies (plugins).
     * Do not forget to remove component plugin script from src/vendor/js
    */
    init: function () {
      theme.disableEmptyLink();
      theme.featherIcons();
      theme.offcanvas();
      theme.offcanvasSidebar();
      theme.formValidation();
      theme.multilevelDropdown();
      theme.langSwitcherSelect();
      theme.searchAutocomplete();
      theme.navbarFixed();
      theme.scrollTo();
      theme.scrollBackTop();
      theme.tooltips();
      theme.popovers();
      theme.toasts();
      theme.countDown();
      theme.rangeSlider();
      theme.dataFilter();
      theme.subscribeForm();
      theme.productGallery();
      theme.creditCard();
      theme.linkedCarousels();
    },

    
    /**
     * Disabling browser from jumping up top when clicking empty (#) links
     * @param {string} selector
    */
    disableEmptyLink: function (selector) {

      selector = 'a[href="#"]';

      $(selector).on('click', function(e) {
        e.preventDefault();
      });
    },


    /**
     * Feater SVG icons
    */
    featherIcons: function () {
      if(typeof feather !== 'undefined') {
        feather.replace();
      }
    },


    /**
     * Toggling offcanvas menu
     * @param {string} triggerOpen
     * @param {string} triggerClose
    */
    offcanvas: function (triggerOpen, triggerClose) {

      triggerOpen = '[data-toggle="offcanvas"]';
      triggerClose = '[data-dismiss="offcanvas"]';

      $(triggerOpen).on('click', function (e) {
        var $target = $(this).attr('href');
        showOffcanvas($target);
        e.preventDefault();
      });

      $(triggerClose).on('click', function () {
        var $target = $('.offcanvas');
        hideOffcanvas($target);
      });

      function showOffcanvas (target, callback) {
        callback = setTimeout(function () {
          $(BODY).addClass('offcanvas-open');
        }, 100);
        $(target).addClass('show', callback);
      }

      function hideOffcanvas (target, callback) {
        callback = setTimeout(function () {
          $(target).removeClass('show');
        }, 500);
        $(BODY).removeClass('offcanvas-open', callback);
      }
    },


    /**
     * Toggling offcanvas sidebar
     * @param {string} trigger
     * @param {string} target
    */
    offcanvasSidebar: function (trigger, target) {

      trigger = '.offcanvas-sidebar-toggle';
      target = '.offcanvas-sidebar';

      $(trigger).on('click', function() {
        $(target).toggleClass('show');
      });

    },


    /**
     * From validation
     * @param {string} selector
    */
    formValidation: function (selector) {

      selector = 'needs-validation';

      window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName(selector);
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
          form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add('was-validated');
          }, false);
        });
      }, false);
    },


    /**
     * Multilevel dropdown
     * @param {string} selector
    */
    multilevelDropdown: function (selector) {

      selector = ".dropdown-menu [data-toggle='dropdown']";

      $(selector).on('click', function (e) {
        e.preventDefault();
        e.stopPropagation();

        $(this).siblings().toggleClass('show');

        if (!$(this).next().hasClass('show')) {
          $(this).parents('.dropdown-menu').first().find('.show').removeClass('show');
        }
        $(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function () {
          $('.dropdown-submenu .show').removeClass('show');
        });
      });
    },


    /**
     * Disable dropdown autohide when select is clicked
     * @param {string} selector
    */
    langSwitcherSelect: function (selector) {

      selector = '.navbar-lang-switcher .custom-select';

      $(selector).on('click', function (e) {
        e.stopPropagation();
      });
    },


    /**
     * Search autocomplete
     * dependency: easy-autocomplete jQuery plugin
     * @param {string} selector
    */
    searchAutocomplete: function (selector) {

      selector = '#site-search';

      var options = {
        url: 'search-autocomplete.json',
        getValue: 'name',
        list: {
          match: {
            enabled: true
          }
        },
        template: {
          type: 'custom',
          method: function(value, item) {
            return "<a href='" + item.link + "'><span class='ac-title'>" + value + "</span><span class='badge badge-" + item.badge + " ml-2'>" + item.type + "</span></a>";
          }
        }
      };

      if ($.fn.easyAutocomplete) {
        $(selector).easyAutocomplete(options);
      }
    },


    /**
     * Fixed navbar
     * @param {string} selector
     * @param {number} scrollOffset [scrollOffset=20]
    */
    navbarFixed: function (selector, scrollOffset) {

      selector = '.navbar.fixed-top';
      scrollOffset = 20;

      if ($(selector).length) {

        var offsetFromTop = parseInt(scrollOffset, 10);

        $(WINDOW).on('scroll', function () {
          if ($(this).scrollTop() > offsetFromTop) {
            $(selector).addClass('stuck');
          } else {
            $(selector).removeClass('stuck');
          }
        });
      }
    },


    /**
     * Smooth scroll to an element
     * @param {string} selector
     * @param {number} duration [duration=1200]
    */
    scrollTo: function (selector, duration) {

      selector = '.scroll-to';
      duration = 1200;

      $(selector).on('click', function (e) {

        var target = $(this).attr('href');
        
        if ('#' === target) {
          return false;
        }
    
        var $target = $( target );
        var animationDuration = parseInt(duration, 10);
        if($target.length) {
          var $elemOffsetTop = $target.data( 'offset-top' ) || 50;
          $('html, body').stop().animate({scrollTop: $( this.hash ).offset().top - $elemOffsetTop}, animationDuration, 'easeOutExpo');
        }
        e.preventDefault();
      });
    },


    /**
     * Animated scroll to top button
     * @param {string} selector
     * @param {number} scrollOffset [scrollOffset=600]
     * @param {number} duration [duration=1200]
    */
    scrollBackTop: function (selector, scrollOffset, duration) {

      selector = '.scroll-to-top-btn';
      scrollOffset = 600;
      duration = 1200;

      if ($(selector).length) {

        var offsetFromTop = parseInt(scrollOffset, 10);
        var animationDuration = parseInt(duration, 10);

        $(WINDOW).on('scroll', function () {
          if ($(this).scrollTop() > offsetFromTop) {
            $(selector).addClass('show');
          } else {
            $(selector).removeClass('show');
          }
        });

        $(selector).on('click', function () {
          $('html, body').stop().animate({scrollTop: 0}, animationDuration, 'easeOutExpo');
        });
      }
    },


    /**
     * Tooltips
     * @param {string} selector
    */
    tooltips: function (selector) {

      selector = '[data-toggle="tooltip"]';

      $(selector).tooltip();
    },


    /**
     * Popovers
     * @param {string} selector
    */
    popovers: function (selector) {

      selector = '[data-toggle="popover"]';

      $(selector).popover();
    },


    /**
     * Toasts
     * @param {string} selector
    */
    toasts: function (selector) {

      selector = '[data-toggle="toast"]';

      $(selector).on('click', function() {
        var target = $(this).data('target');
        $(target).toast('show');
      });
    },


    /**
     * Countdown
     * @param {string} selector
    */
    countDown: function (selector, trigger) {

      selector = '.countdown';

      $(selector).each( function() {
        var countDown = $(this),
            dateTime = $(this).data('date-time'),
            labels = $(this).data('labels');

        var countDownTrigger = ( trigger ) ? trigger : countDown;
        countDownTrigger.countdown(dateTime, function(event) {
          $(this).html(event.strftime(
            '<div class="countdown-item"><div class="countdown-value">%D</div><div class="countdown-label">' + labels['label-day'] + '</div></div><div class="countdown-item"><div class="countdown-value">%H</div><div class="countdown-label">' + labels['label-hour'] + '</div></div><div class="countdown-item"><div class="countdown-value">%M</div><div class="countdown-label">' + labels['label-minute'] + '</div></div><div class="countdown-item"><div class="countdown-value">%S</div><div class="countdown-label">' + labels['label-second'] + '</div></div>'
          ));
        });
      });
    },


    /**
     * Range slider
     * @param {string} selector
    */
    rangeSlider: function (selector) {

      selector = '.range-slider';

      $(selector).each(function() {
        var self = $(this);
        var rangeSlider = self.find('.ui-range-slider');
        var options = {
          dataStartMin: parseInt(rangeSlider.parent().data( 'start-min' ), 10),
          dataStartMax: parseInt(rangeSlider.parent().data( 'start-max' ), 10),
          dataMin: parseInt(rangeSlider.parent().data( 'min' ), 10),
          dataMax: parseInt(rangeSlider.parent().data( 'max' ), 10),
          dataStep: parseInt(rangeSlider.parent().data( 'step' ), 10),
          valueMin: self.find('.ui-range-value-min span'),
          valueMax: self.find('.ui-range-value-max span'),
          valueMinInput: self.find('.ui-range-value-min input'),
          valueMaxInput: self.find('.ui-range-value-max input')
        }
        
        noUiSlider.create(rangeSlider[0], {
          start: [ options.dataStartMin, options.dataStartMax ],
          connect: true,
          step: options.dataStep,
          range: {
            'min': options.dataMin,
            'max': options.dataMax
          }
        });
    
        rangeSlider[0].noUiSlider.on('update', function(values, handle) {
          var value = values[handle];
          if ( handle ) {
            options.valueMax.text(Math.round(value));
            options.valueMaxInput.val(Math.round(value));
          } else {
            options.valueMin.text(Math.round(value));
            options.valueMinInput.val(Math.round(value));
          }
        });
      });
    },


    /**
     * Data filtering (Comparison table)
     * @param {string} trigger
     * @param {string} target
    */
    dataFilter: function (trigger, target) {

      trigger = '[data-filter="trigger"]';
      target = '[data-filter="target"]';

      $(trigger).on('change', function() {
        var selected = $(this).find('option:selected').val().toLowerCase();
        $(target).css('display', 'none');
        $('#' + selected).css('display', 'table-row-group');
        selected === 'all' ? $(target).css('display', 'table-row-group') : '';
      });
    },


    /**
     * Ajaxify subscription form (MAilChimp)
     * @param {string} form
     * @param {string} input
     * @param {string} button
     * @param {string} status
    */
    subscribeForm: function (form, input, button, status) {

      form = '#mc-embedded-subscribe-form';
      input = '#mce-EMAIL';
      button = '#mc-embedded-subscribe';
      status = '.subscribe-status';

      var $form = $(form);
      var $input = $(input);
      var $button = $(button);
      var $status = $(status);
      var buttonInitText = $button.text();
      var input = $button.text();

      if($form.length) {
        $button.bind('click', function(event) {
          if(event) event.preventDefault();
          register($form);
        });
      }

      function register($form) {
        $button.text('Sending...');
        $.ajax({
          type: $form.attr('method'),
          url: $form.attr('action'),
          data: $form.serialize(),
          cache: false,
          dataType: 'jsonp',
          contentType: 'application/json; charset=utf-8',
          error: function (err) { alert('Could not connect to the registration server. Please try again later.') },
          success: function (data) {
            if(data.result === 'success') {
              $status.removeClass('status-error').addClass('status-success').text('Thank you for subscribing. We have sent you a confirmation email.')
              $button.text(buttonInitText, setTimeout(function() {
                $status.removeClass('status-success').text('');
              }, 5000));
              $input.val('');
            } else {
              $status.removeClass('status-success').addClass('status-error').text(data.msg.substring(4));
              $button.text(buttonInitText, setTimeout(function() {
                $status.removeClass('status-error').text('');
              }, 5000));
            }
          }
        });
      };
    },



    /**
     * Product gallery
     * @param {string} selector
    */
    productGallery: function (selector) {

      selector = '.product-carousel';

      function activeHash(e) {
        var i = e.item.index;
        var $activeHash = $('.owl-item').eq(i).find('[data-hash]').attr('data-hash');
        $('.product-thumbnails li').removeClass('active');
        $('[href="#' + $activeHash + '"]').parent().addClass('active');
        $('[data-hash="' + $activeHash + '"]').parent().addClass('active');
      }

      if($(selector).length) {
        // Carousel init
        $(selector).owlCarousel({
          items: 1,
          loop: false,
          dots: false,
          nav: true,
          margin: 12,
          autoHeight: true,
          URLhashListener: true,
          startPosition: 'URLHash',
          onTranslate: activeHash
        });
      }
    },


    /**
     * Interactive credit card
     * @param {string} selector
    */
    creditCard: function (selector) {
        
      selector = '.interactive-credit-card';

      if($(selector).length) {
        $(selector).card({
          form: selector,
          container: '.card-wrapper'
        });
      }
    },


    /**
     * Linked carousels (Featured posts slider)
     * @param {string} triggerCarousel
     * @param {string} targetCarousel
    */
    linkedCarousels: function (triggerCarousel, targetCarousel) {

      triggerCarousel = '.trigger-carousel';
      targetCarousel = $(triggerCarousel).data('target-carousel');

      if($(triggerCarousel).length) {
        $(triggerCarousel).on('change.owl.carousel', function (event) {
          if (event.namespace && event.property.name === 'position') {
            var target = event.relatedTarget.relative(event.property.value, true);
            $(targetCarousel).owlCarousel('to', target, 350, true);
          }
        });
      }
    }

  }


  /**
   * Init theme core on document.ready
  */
  $(function() {
    theme.init();
  });

})(jQuery);
