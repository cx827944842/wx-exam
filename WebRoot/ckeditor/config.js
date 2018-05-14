/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	config.toolbarGroups = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		'/',
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		{ name: 'about', groups: [ 'about' ] },
		'/',
		{ name: 'others', groups: [ 'others' ] }
	];
	config.removeButtons = 'Source,NewPage,Save,Preview,Print,Templates,Find,Replace,SelectAll,Scayt,Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,NumberedList,BulletedList,Indent,Outdent,Blockquote,CreateDiv';
	config.image_previewText=' ';
	config.filebrowserImageUploadUrl="../ckeditor/uploadFile";
};
CKEDITOR.on('instanceReady', function (ev) {
    var editor = ev.editor,
        dataProcessor = editor.dataProcessor,
        htmlFilter = dataProcessor && dataProcessor.htmlFilter;

    // Out self closing tags the HTML4 way, like <br>.
    dataProcessor.writer.selfClosingEnd = '>';

    // Make output formatting behave similar to FCKeditor
    var dtd = CKEDITOR.dtd;
    for (var e in CKEDITOR.tools.extend({}, dtd.$nonBodyContent, dtd.$block, dtd.$listItem, dtd.$tableContent)) {
        dataProcessor.writer.setRules(e,
            {
                indent: true,
                breakBeforeOpen: true,
                breakAfterOpen: false,
                breakBeforeClose: !dtd[e]['#'],
                breakAfterClose: true
            });
    }

    // Output properties as attributes, not styles.
    htmlFilter.addRules(
    {
        elements:
        {
            $: function (element) {
                // Output dimensions of images as width and height
                if (element.name == 'img') {
                    var style = element.attributes.style;
                    delete element.attributes.style;
                }

                if (!element.attributes.style)
                    delete element.attributes.style;

                return element;
            }
        },

      
    });
});