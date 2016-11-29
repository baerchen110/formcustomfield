AUI.add(
	'liferay-ddm-form-field-upload',
	function(A) {
		var UploadField = A.Component.create(
			{
				ATTRS: {
					dataType: {
						value: 'string'
					},

					type: {
						value: 'file'
					}
				},

				EXTENDS: Liferay.DDM.Renderer.Field,

				NAME: 'liferay-ddm-form-field-upload',

				prototype: {
					getTemplateContext: function() {
						var instance = this;

						var value = instance.getContextValue();

						return A.merge(
								UploadField.superclass.getTemplateContext.apply(instance, arguments),
							{
								value: value
							}
						);
					}
				}
			}
		);

		
		Liferay.namespace('DDM.Field').Upload = UploadField;
	},
	'',
	{
		requires: ['aui-datepicker', 'liferay-ddm-form-renderer-field']
	}
);