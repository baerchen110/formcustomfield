// This file was automatically generated from upload.soy.
// Please don't edit this file by hand.

/**
 * @fileoverview Templates in namespace ddm.
 * @public
 */

if (typeof ddm == 'undefined') { var ddm = {}; }


ddm.upload = function(opt_data, opt_ignored) {
  return '<div class="form-group liferay-ddm-form-field-upload liferay-ddm-form-field-text" data-fieldname="' + soy.$$escapeHtmlAttribute(opt_data.name) + '">' + ((opt_data.showLabel) ? '<label class="control-label" for="' + soy.$$escapeHtmlAttribute(opt_data.name) + '">' + soy.$$escapeHtml(opt_data.label) + ((opt_data.required) ? '<span class="icon-asterisk text-warning"></span>' : '') + '</label>' + ((opt_data.tip) ? '<p class="liferay-ddm-form-field-tip">' + soy.$$escapeHtml(opt_data.tip) + '</p>' : '') : '') + '<div class="input-group input-group-container"><input type="file" name="' + soy.$$escapeHtmlAttribute(opt_data.name) + '" value="' + soy.$$escapeHtmlAttribute(opt_data.value) + '" size="40"></div>' + ((opt_data.childElementsHTML) ? soy.$$filterNoAutoescape(opt_data.childElementsHTML) : '') + '</div>';
};
if (goog.DEBUG) {
  ddm.upload.soyTemplateName = 'ddm.upload';
}
