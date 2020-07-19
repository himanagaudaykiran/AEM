use(function () {
    var Constants = {
        DESCRIPTION_PROPS: "jcr:title",
        DESCRIPTION_PROP: "jcr:desk",
        DESCRIPTION_LENGTH: 50
    };

    var title = properties.get(Constants.DESCRIPTION_PROPS, "").substr(0, Constants.DESCRIPTION_LENGTH);
    var description = properties.get(Constants.DESCRIPTION_PROP, "").substr(0, Constants.DESCRIPTION_LENGTH);
	
    return {
        title: title,
        description: description,
    };
});