;(function() {
	AUI().applyConfig(
		{
			groups: {
				'field-upload': {
					base: MODULE_PATH + '/',
					combine: Liferay.AUI.getCombine(),
					modules: {
						'liferay-ddm-form-field-upload': {
							condition: {
								trigger: 'liferay-ddm-form-renderer'
							},
							path: 'upload_field.js',
							requires: [
								'aui-datepicker',
								'liferay-ddm-form-renderer-field'
							]
						},
						'liferay-ddm-form-field-upload-template': {
							condition: {
								trigger: 'liferay-ddm-form-renderer'
							},
							path: 'upload.soy.js',
							requires: [
								'soyutils'
							]
						}
					},
					root: MODULE_PATH + '/'
				}
			}
		}
	);
})();